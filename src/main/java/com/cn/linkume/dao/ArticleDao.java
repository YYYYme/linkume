package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.Article;

public interface ArticleDao {  
     public List<Article> selectByPid(Integer pid);  
     public Article selectByPrimaryKey(Integer id);
     public List<Article> selectListByPrimaryKey(Integer id);
	public void insertArticle(Article article);
	public void deleteByPrimaryKey(Integer nodeId);
	public void updateByPrimaryKeySelective(Article article);
}