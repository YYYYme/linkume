package com.cn.linkume.util.chess;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;

import com.cn.linkume.pojo.ChessMsg;
import com.cn.linkume.pojo.ChessUser;
import com.cn.linkume.util.chess.ChessServer.ServerListener;

public class MsgServer implements ServerListener {
    @Value("${chess.server.restarttime}")
    private int restarttime;
    
	public interface MsgServerListener {
		public void onCountChange(int count);

		public void onErr(String err);

		public void onLogin(String name);

		public void onLogout(String name);
	}

	private ChessServer server;
	private int size;
	private ArrayList<ChessUser> users;
	private MsgServerListener msgServerListener;

	public MsgServer(int size, MsgServerListener msgServerListener) {
		this.size = size;
		this.msgServerListener = msgServerListener;
		start();
	}

	public void start() {
		users = new ArrayList<ChessUser>();
		server = new ChessServer(size, this);
		server.start();
		System.out.println("chess listener start");
	}

	@Override
	public void onStop(String err) {
		for (int i = 0; i < restarttime; i++) {
			msgServerListener.onErr("服务停止，" + ( restarttime-i) + "秒后尝试启动！");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		start();
	}

	@Override
	public void onReceive(ChessMsg msg) {
		ChessUser old = indexOf(msg.getTo());
		try {
			old.sendMsg(msg);
		} catch (Exception e) {
		}
	}

	@Override
	public void onLogin(Socket socket, String name) {
		ChessUser user = new ChessUser(socket, name);
		ChessUser old = null;
		synchronized (this) {
			old = indexOf(name);
		}
		if (old != null) {
			try {
				ChessMsg.send(old.getSocket(), "异地登录");
			} catch (Exception e1) {
			}
			try {
				old.getSocket().close();
			} catch (IOException e) {
			}
		}
		add(user);
	}

	@Override
	public void onLogout(Socket socket) {
		remove(socket);
	}

	public synchronized void add(ChessUser user) {
		msgServerListener.onLogin(user.getName());
		users.add(user);
		msgServerListener.onCountChange(server.getNum());
	}

	public synchronized void remove(Socket socket) {
		int i = indexOf(socket);
		msgServerListener.onLogout(users.get(i).getName());
		users.remove(i);
		msgServerListener.onCountChange(server.getNum());
	}
	public ChessUser indexOf(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name)) {
				return users.get(i);
			}
		}
		return null;
	}

	public int indexOf(Socket socket) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getSocket().equals(socket)) {
				return i;
			}
		}
		return -1;
	}
}
