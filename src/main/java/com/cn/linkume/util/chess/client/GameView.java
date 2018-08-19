package com.cn.linkume.util.chess.client;


@SuppressWarnings("serial")
public class GameView {
	private int[] map;

	public int[] getMap() {
		return map;
	}

	public void setMap(int[] map) {
		this.map = map;
		try {
		} catch (Exception e) {
		}
	}

	// 0，空；1，选择；
	// 11，黑士；21，红士；
	// 1：士；2：象；3：炮；4：将；5：马；6：卒；7：车
	public GameView(int[] map) {
		this.map = map;
	}

}
