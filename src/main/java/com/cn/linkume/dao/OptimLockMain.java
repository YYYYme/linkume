package com.cn.linkume.dao;

import com.cn.linkume.controller.OptimThread;

public class OptimLockMain {

	// 文件版本号
	static int version = 1;
	// 操作文件
	static String file = "d://IT小奋斗.txt";

	/**
	 * 获取版本号
	 * 
	 * @return
	 */
	public static int getVersion() {
		return version;
	}

	/**
	 * 更新版本号
	 */
	public static void updateVersion() {
		version += 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			new OptimThread(String.valueOf(i), getVersion(), file).start();
		}
	}

}