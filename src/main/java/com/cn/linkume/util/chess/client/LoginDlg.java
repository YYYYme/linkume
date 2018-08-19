/*
 * LoginDlg.java
 *
 * Created on __DATE__, __TIME__
 */

package com.cn.linkume.util.chess.client;

import java.io.IOException;



/**
 * 
 * @author __USER__
 */
public class LoginDlg {
	public interface LoginDlgListener {
		public void join(String selfName, String otherName);

		public void create(String selfName, String otherName);
	}

	private LoginDlgListener listener;

	public LoginDlg(boolean modal,
			LoginDlgListener listener) {
		this.listener = listener;
	}

	public void join() {
		String sName = "";
		String oName = "";
		listener.join(sName, oName);
	}

	public void create() {
		String sName = "";
		String oName = "";
		listener.create(sName, oName);
	}

	private boolean isLogin;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}