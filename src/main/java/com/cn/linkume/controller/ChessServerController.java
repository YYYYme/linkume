package com.cn.linkume.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 棋盘服务器
 */
@Controller
@RequestMapping("/chess/server")
public class ChessServerController {

	/**
	 * 启动服务
	 */
	@RequestMapping(value = "/getTree", method = RequestMethod.GET)
	@ResponseBody
	public void startServer() {

	}


	
}