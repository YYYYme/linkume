package com.cn.linkume.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.cn.linkume.pojo.User;
import com.cn.linkume.service.IUserService;
import com.cn.linkume.vo.AjaxResultVo;
import com.cn.linkume.vo.PageData;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/queryUser")
	@ResponseBody
	public Map<String, Object> toHtml(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userId = Integer.parseInt(request.getParameter("id"));

		User user = this.userService.getUserById(userId);
		map.put("data", user);
		map.put("msg", "true");
		return map;
	}

	@RequestMapping("/queryAllUser")
	@ResponseBody
	public Map<String, Object> queryAllUser(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<User> user = this.userService.queryAllUser();
		map.put("data", user);
		map.put("msg", "true");
		return map;
	}

	/**
	 * 分页查询用户列表
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author hanshumin
	 * @date 2018年5月9日 上午11:04:14
	 */
	@RequestMapping("/queryUserByPage")
	@ResponseBody
	public AjaxResultVo queryUserByPage(Integer pageNo, Integer pageSize, HttpServletRequest request) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		PageData<User> user = this.userService.queryUserByPage(pageNo, pageSize);
		ajaxResultVo.setData(user);
		ajaxResultVo.setRet(true);
		return ajaxResultVo;
	}
	
	@RequestMapping(value="/insertUser")
	@ResponseBody
	public AjaxResultVo insertUser(HttpServletRequest request, Model model) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String ageStr = request.getParameter("age");
		int age = 0;
		if (StringUtils.isBlank(userName)) {
			ajaxResultVo.setCode(1);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("用户名为空");
		}
		if (StringUtils.isBlank(password)) {
			ajaxResultVo.setCode(2);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("密码为空");
		}
		if (!StringUtils.isBlank(ageStr)) {
			age = Integer.valueOf(ageStr);
		}
		
		User user = new User();
		user.setUserName(userName);
		//查询用户是否已存在
		User userExist = userService.queryUserByParams(user);
		if (null != userExist) {
			ajaxResultVo.setCode(1);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("用户名已存在");
			return ajaxResultVo;
		}
		user.setPassword(password);
		user.setAge(age);
		boolean isSuccess = this.userService.insertUser(user);
		if (isSuccess) {
			ajaxResultVo.setCode(0);
			ajaxResultVo.setRet(true);
		} else {
			ajaxResultVo.setCode(0);
			ajaxResultVo.setRet(true);
		}
		return ajaxResultVo;
	}

	@RequestMapping(value = "/queryCount", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryCount(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		List user = this.userService.queryAllUser();
		int count = 0;
		if (CollectionUtils.isNotEmpty(user)) {
			count = user.size();
		}
		map.put("count", count);
		return map;
	}
	
	/**
	 * 登陆验证
	 *
	 * @param request
	 * @return
	 * @author hanshumin
	 * @date 2018年5月8日 上午10:32:40
	 */
	@RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
	@ResponseBody
	public AjaxResultVo login(HttpServletRequest request) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (StringUtils.isBlank(userName)) {
			ajaxResultVo.setCode(1);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("userName is empty");
			return ajaxResultVo;
		}
		if (StringUtils.isBlank(password)) {
			ajaxResultVo.setCode(2);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("password is empty");
			return ajaxResultVo;
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		User userResult = userService.queryUserByParams(user);
		if (null != userResult) {
			ajaxResultVo.setCode(0);
			ajaxResultVo.setRet(true);
		} else {
			ajaxResultVo.setCode(3);
			ajaxResultVo.setRet(false);
			ajaxResultVo.setMsg("userName or password is wrong");
			return ajaxResultVo;
		}
		return ajaxResultVo;
	}
}
