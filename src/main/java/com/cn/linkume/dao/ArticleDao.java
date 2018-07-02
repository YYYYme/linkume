package com.cn.linkume.dao;

import java.util.List;

import com.cn.linkume.pojo.Article;

public interface ArticleDao {  
     public List<Article> selectByPid(Integer pid);  
     public List<Article> selectByPrimaryKey(Integer id);
	public void insertArticle(Article article);  
}  