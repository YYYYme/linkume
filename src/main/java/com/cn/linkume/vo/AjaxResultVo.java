package com.cn.linkume.vo;

import java.io.Serializable;

/**
 * AJAX返回对象
 *
 * @author tangqing
 * @date 2017年9月21日 下午5:50:45
 */
public class AjaxResultVo implements Serializable {

	private static final long serialVersionUID = 6008783048273879420L;
	
	private boolean ret;
	
	private Integer code = 0;
	
	private String msg = "OK";
	
	private Object data;
	
	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

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
	
	public static AjaxResultVo success(Object object, Integer code, String msg) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		ajaxResultVo.ret = true;
		ajaxResultVo.code = code;
		ajaxResultVo.data = object;
		ajaxResultVo.msg = msg;
        return ajaxResultVo;
    }
	
	public static AjaxResultVo success() {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		ajaxResultVo.ret = true;
        return ajaxResultVo;
    }
	
	public static AjaxResultVo success(Integer code, String msg) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		ajaxResultVo.ret = true;
		ajaxResultVo.code = code;
		ajaxResultVo.msg = msg;
        return ajaxResultVo;
    }
	
	public static AjaxResultVo fail(Integer code, String msg) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		ajaxResultVo.ret = false;
		ajaxResultVo.code = code;
		ajaxResultVo.msg = msg;
        return ajaxResultVo;
    }
	
	public static AjaxResultVo fail() {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		ajaxResultVo.ret = false;
        return ajaxResultVo;
    }
	
}
