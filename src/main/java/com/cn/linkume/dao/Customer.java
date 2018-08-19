package com.cn.linkume.dao;

import java.util.concurrent.CountDownLatch;

/**
 * 顾客，实现runnable()接口，多个人可以一起存钱
 * 
 */
public class Customer implements Runnable {

	/**
	 * 存钱类型
	 */
	public static final String TYPE_ADD = "add";
	/**
	 * 取钱类型
	 */
	public static final String TYPE_REDUCE = "reduce";
	/**
	 * 银行
	 */
	private Bank bank;
	/**
	 * 对钱的操作类型，存钱or取钱
	 */
	private String type;
	/**
	 * 操作的次数，理论上是个正数
	 */
	private int time;
	/**
	 * 要存或者取多少钱
	 */
	private int money;
	/**
	 * 计数器
	 */
	private CountDownLatch latch;

	public Customer() {
	}

	public Customer(Bank bank, String type, int time, int money,
			CountDownLatch latch) {
		this.bank = bank;
		this.type = type;
		this.time = time;
		this.money = money;
		this.latch = latch;
	}

	@Override
	public void run() {
		for (int x = 0; x < time; x++) {
			if (TYPE_ADD.equals(type)) {
				bank.add(money);
			} else if (TYPE_REDUCE.equals(type)) {
				bank.reduce(money);
			}
			latch.countDown();// 让latch中的数值减一
		}
	}
}