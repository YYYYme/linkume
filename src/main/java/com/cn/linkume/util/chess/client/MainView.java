package com.cn.linkume.util.chess.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.cn.linkume.util.chess.client.Game.GameListener;
import com.cn.linkume.util.chess.client.MsgIo.MsgListener;

public class MainView implements MsgListener,GameListener{
	
	private MsgIo msgIo;
	private Game game;
	public MainView(MsgIo msgIo,int color) {
		this.msgIo = msgIo;
		this.game = new Game(color, msgIo, this);
		msgIo.addListener(this);
	}
	//发送消息
	public void send() {
		showMsg(new Msg(msgIo.getSelfName(), msgIo.getOtherName(), ""));
		msgIo.sendMsg("msg:");
	}
	
	public void peace() {
		msgIo.sendMsg("求和");
	}
	public void looser() {
		game.looser();
	}
	@Override
	public void onReceiveMsg(Msg msg) {
		if(msg.getTo().equals(msgIo.getSelfName())){
			String content;
			if((content=msg.getContent()).contains("msg:")){
				msg.setContent(content.replace("msg:", ""));
				showMsg(msg);
			}
		}
	}
	//格式化时间
	private SimpleDateFormat sdf = new SimpleDateFormat(" hh:mm:ss\n");
	public void showMsg(Msg msg){
		String all = "\n";
		all+=msg.getFrom();
		all+=sdf.format(new Date());
		all+=" "+msg.getContent();
	}
	@Override
	public void loginFailed() {
		
	}
	@Override
	public void onReceiveErr(String err) {
		System.exit(0);
	}
	@Override
	public void loginSuccess() {
		
	}

	@Override
	public void onEat() {
	}

	@Override
	public void onGameOver(boolean isWin) {
			if (isWin) {
				//JOptionPane.showMessageDialog(this,"恭喜你赢了！");
			} else {
				//JOptionPane.showMessageDialog(this,"很遗憾你输了！");
			}
	}
	@Override
	public void onPeace() {
		//JOptionPane.showMessageDialog(this,"和棋！");
	}

	@Override
	public void qurryPeace() {
		/*int i = JOptionPane.showConfirmDialog(this, "对方请求和棋，是否同意？","求和",2);
		if(i==0){
			game.peace();
		}*/
	}
	@Override
	public void onUpdateTime(int self, int other) {
		// TODO Auto-generated method stub
		
	}
}
