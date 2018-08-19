package com.cn.linkume.util.chess;

import com.cn.linkume.util.chess.MsgServer.MsgServerListener;

public class MsgServerView implements MsgServerListener {
	private MsgServer msgServer;

	public MsgServerView(int size) {
		this.msgServer = new MsgServer(size, this);
	}

	public void start() {
		this.msgServer.start();
	}

	public void onCountChange(int count) {
		
	}

	public void onErr(String err) {
		
	}

	public void onLogin(String name) {
		System.out.println(name + "login in");
	}

	public void onLogout(String name) {
		System.out.println(name + "login out");
	}
}
