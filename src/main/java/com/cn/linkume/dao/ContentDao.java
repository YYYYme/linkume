package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.Content;

public interface ContentDao {  
     public Content selectByArticleId(Integer pid);  
     public Content selectByPrimaryKey(Integer id);
     public List<Content> selectListByPrimaryKey(Integer id);
	public void insertContent(Content content);
	public void deleteByPrimaryKey(Integer nodeId);
	public void updateByPrimaryKeySelective(Content article);
	public void updateByArticleId(Content article);
	
}