package com.cn.linkume.pojo;

import java.io.Serializable;
public class GameRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7400544434964667002L;
	private Integer id;
	private Integer userCount;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
