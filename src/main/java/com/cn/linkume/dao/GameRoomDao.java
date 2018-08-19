package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.GameRoom;

public interface GameRoomDao {
    
    List<GameRoom> queryAllGameRoom();

	void updataUserCount(GameRoom gameRoom);
    
}