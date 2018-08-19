package com.cn.linkume.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.linkume.dao.GameRoomDao;
import com.cn.linkume.pojo.GameRoom;
import com.cn.linkume.service.ChessServerService;
@Service("chessServerService")  
public class ChessServerServiceImpl implements ChessServerService {
	@Resource
	private GameRoomDao gameRoomDao;
	private static Logger logger = Logger.getLogger(ChessServerServiceImpl.class);

	@Override
	public List<GameRoom> queryAllGameRoom(){
		return this.gameRoomDao.queryAllGameRoom();
	}

	@Override
	public void updataUserCount(GameRoom gameRoom) {
		this.gameRoomDao.updataUserCount(gameRoom);
		
	}
	
}