package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.Department;

public interface IDepartmentDao {
	public Department selectByPrimaryKey(Integer id);
	
	List<Department> selectSubDepts(Integer parentId);
	
	void insertDepartment(Department dept);
}
