package com.cn.linkume.pojo;

import java.io.Serializable;

public class Result implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean result = false;//结果
	public String msg;//提示消息
	public Object data;//数据
	public int status;//状态
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public boolean isSucc() {
		return result;
	}
	
	public boolean isFail() {
		return !result;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
