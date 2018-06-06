package com.cn.linkume.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.linkume.dao.IDepartmentDao;
import com.cn.linkume.pojo.Department;
import com.cn.linkume.service.IDepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

	@Resource
	private IDepartmentDao deptDao;
	
	public Department findDeptById(int id) {
		return this.deptDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> findSubDepts(int id) {
		return this.deptDao.selectSubDepts(id);
	}

	@Override
	public void addDepartment(Department dept) {
		this.deptDao.insertDepartment(dept);
	}


}
