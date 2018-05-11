package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.User;

public interface IUserDao {
	public User selectByPrimaryKey(Integer userId);
	int deleteByPrimaryKey(Integer id);

    boolean insertUser(User record);

    int insertSelective(User record);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> queryAllUser();
    
	public User selectByParams(User user);
}
