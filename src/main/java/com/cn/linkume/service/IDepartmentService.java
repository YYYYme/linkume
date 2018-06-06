package com.cn.linkume.service;

import java.util.List;

import com.cn.linkume.pojo.Department;

public interface IDepartmentService {
	Department findDeptById(int id);
	
	List<Department> findSubDepts(int id);
	
	void addDepartment(Department dept);
}
