package com.cn.linkume.service;

import java.util.List;

import com.cn.linkume.pojo.User;
import com.cn.linkume.vo.PageData;

public interface IUserService {
	public User getUserById(int userId);
	public List<User> queryAllUser();
	public boolean insertUser(User user);
	/**
	 * 根据条件查询用户
	 *
	 * @param user
	 * @return
	 * @author hanshumin
	 * @date 2018年5月8日 上午10:15:13
	 */
	public User queryUserByParams(User user);
	
	/**
	 * 分页查询用户列表
	 *
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author hanshumin
	 * @date 2018年5月9日 上午11:07:08
	 */
	public PageData<User> queryUserByPage(Integer pageNo, Integer pageSize);
}
