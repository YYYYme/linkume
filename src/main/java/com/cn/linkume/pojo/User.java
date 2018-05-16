package com.cn.linkume.pojo;

import java.io.Serializable;
public class User implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = -7400544434964667002L;
	public int id;
	public int age;
	public String userName;
	public String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
