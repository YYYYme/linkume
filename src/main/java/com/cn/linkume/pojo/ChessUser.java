package com.cn.linkume.pojo;

import java.net.Socket;

public class ChessUser {
	private Socket socket;
	private String name;
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ChessUser(Socket socket, String name) {
		super();
		this.socket = socket;
		this.name = name;
	}
	public void sendMsg(ChessMsg msg) throws Exception{
		ChessMsg.send(socket, msg.toString());
	}
}
