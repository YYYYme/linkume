package com.cn.linkume.service;

import java.util.List;

import com.cn.linkume.pojo.GameRoom;

public interface ChessServerService {
	/**
	 * 查询房间
	 *
	 * @param user
	 * @return
	 * @author hanshumin
	 * @date 2018年5月8日 上午10:15:13
	 */
	public List<GameRoom> queryAllGameRoom();

	public void updataUserCount(GameRoom gameRoom);
	
}