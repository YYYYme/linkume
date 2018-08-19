package com.cn.linkume.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.linkume.pojo.GameRoom;
import com.cn.linkume.service.ChessServerService;
import com.cn.linkume.util.chess.MsgServerView;

/**
 * 棋盘服务器
 */
@Controller
@RequestMapping("/chess/server")
public class ChessServerController {
	@Value("${chess.server.size}")
	private int size; 
	@Resource
	private ChessServerService chessServerService;
	
	/**
	 * 启动服务
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public void startServer() {
		new MsgServerView(size);
	}

	/**
	 * 查询房间
	 */
	@RequestMapping(value = "/queryGameRoom", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryGameRoom() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GameRoom> list = chessServerService.queryAllGameRoom();
		map.put("rows", list);
		map.put("total", list.size());
		map.put("msg", "true");
		return map;
	}
	
	/**
	 * 修改人数
	 */
	@RequestMapping(value = "/updataUserCount", method = RequestMethod.GET)
	@ResponseBody
	public void updataUserCount(Integer id, Integer count) {
		GameRoom gameRoom = new GameRoom();
		gameRoom.setId(id);
		gameRoom.setUserCount(count+1);
		chessServerService.updataUserCount(gameRoom);
	}
	
}