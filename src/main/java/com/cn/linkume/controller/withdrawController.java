package com.cn.linkume.controller;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.linkume.dao.Bank;
import com.cn.linkume.dao.Customer;

@Controller
@RequestMapping("/withdraw")
public class withdrawController {

	/**
	 * 银行存钱的多线程实例
	 * <p>
	 * 【需求：】 银行有一个金库。 有两个储户分别存或者取n * 100。 目的：该程序是否有安全问题，如果有，如何解决？
	 * <p>
	 * 【如何找问题：】 1，明确哪些代码是多线程运行代码。 2，明确共享数据。 3，明确多线程运行代码中哪些语句是操作共享数据的。
	 * 
	 */
	public static void main(String[] args) {
		// 一个银行and多个客户
		Bank bank = new Bank();
		int time = 200;
		int money = 100;
		final CountDownLatch latch= new CountDownLatch(time * 2);
		// 这个客户存钱
		Customer c1 = new Customer(bank, Customer.TYPE_ADD, time, money, latch);
		// 这个客户取钱
		Customer c2 = new Customer(bank, Customer.TYPE_REDUCE, time, money, latch);

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();

		try {
			latch.await();//阻塞当前线程直到latch中数值为零才执行
			Class<?> clazz = Class.forName("com.cn.linkume.dao.Bank");
			Field sumFs = clazz.getDeclaredField("sum");
			sumFs.setAccessible(true);
			Object m = sumFs.get(bank);
			System.out.println("总钱数：" + m);
			int sum = bank.getSum();
			System.out.println("总钱数：" + sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
