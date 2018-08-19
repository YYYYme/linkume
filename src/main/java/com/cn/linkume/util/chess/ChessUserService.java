package com.cn.linkume.util.chess;

import com.cn.linkume.pojo.ChessMsg;
import org.springframework.beans.factory.annotation.Value;

import java.net.Socket;
import java.net.SocketException;

public class ChessUserService implements Runnable {
	@Value("${chess.server.timeout}")
	private int timeout;
	
	private Socket socket;
	private ChessServer server;

	public ChessUserService(Socket socket, ChessServer server) {
		this.socket = socket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			socket.setSoTimeout(timeout);
		} catch (SocketException e1) {
		}
		// 1.��½
		if (!server.login(socket)) {
			return;
		}
		// 2.��ȡ��Ϣ
		try {
			String data = null;
			while ((data = ChessMsg.read(socket)) != null) {
				try {
					ChessMsg msg = new ChessMsg(data);
					server.dealMsg(msg);
				} catch (Exception e) {
				}
			}
		} catch (Exception e1) {
		}
		server.logout(socket);
	}
}
