package com.cn.linkume;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.linkume.pojo.Article;
import com.cn.linkume.pojo.Content;
import com.cn.linkume.pojo.User;
import com.cn.linkume.service.ArticleService;
import com.cn.linkume.service.IUserService;

//让测试运行于Spring环境  
@RunWith(SpringJUnit4ClassRunner.class)
// 引入Spring配置
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	@Resource
	private IUserService userService;
	@Resource
	private ArticleService articleService;

	/*
	 * @Before public void before() { ac = new
	 * ClassPathXmlApplicationContext("spring-mvc.xml"); userService =
	 * (IUserService) ac.getBean("userService"); }
	 */

	@SuppressWarnings("unused")
	@Test
	public void test1() {
		User user = userService.getUserById(1);
		logger.info("UserName:" + user.getUserName());
	}

	@Test
	public void test2() {
		User user = new User();
		// user.setId(4);
		user.setUserName("业务员");
		user.setPassword("123456");
		user.setAge(0);
		boolean is = userService.insertUser(user);
		logger.info("insert:" + user.getUserName());
	}
	
	@Test
	public void testArticleService() {
		articleService.addNode("123", 5);
	}
}