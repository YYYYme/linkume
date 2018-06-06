package com.cn.linkume.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.linkume.pojo.Department;
import com.cn.linkume.service.IDepartmentService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Resource
	private IDepartmentService deptService;
	
	@RequestMapping("/findSubDepts")
	@ResponseBody
	public Map<String, Object> findSubDepts(HttpServletRequest request,Model model){
		int parentId = Integer.parseInt(request.getParameter("id"));
		List<Department> subDepts = this.deptService.findSubDepts(parentId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", subDepts);
		map.put("msg", true);
		return map;
	}
}
