package com.cn.linkume.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.linkume.dao.IUserDao;
import com.cn.linkume.dao.plugin.PageHelper;
import com.cn.linkume.pojo.User;
import com.cn.linkume.service.IUserService;
import com.cn.linkume.vo.PageData;
@Service("userService")  
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Override
	public User getUserById(int userId) {
		logger.info("UserServiceImpl getUserById");
		return this.userDao.selectByPrimaryKey(userId);
	}
	@Override
	@Transactional
	public boolean insertUser(User user) {
		boolean result =  this.userDao.insertUser(user);
		return result;
	}
	
	public List<User> queryAllUser(){
		return this.userDao.queryAllUser();
	}
	@Override
	public User queryUserByParams(User user) {
		return userDao.selectByParams(user);
	}
	
	@Override
	public PageData<User> queryUserByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<User> userList = userDao.queryAllUser();
		PageData<User> pageData = PageHelper.endPage(User.class);
		pageData.setPageList(userList);
		return pageData;
	}
	@Override
	public int deleteByPrimaryKey(int userId) {
		return this.userDao.deleteByPrimaryKey(userId);
	}
}
