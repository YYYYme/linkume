package com.cn.linkume.service;

import java.util.List;

import com.cn.linkume.pojo.Article;


public interface ArticleService {  
    public List<Article> findByPid(Integer pid);  
    public List<Article> findById(Integer id);
	public Boolean addNode(String name, Integer nodeId);  
	public Boolean removeNode(Integer nodeId);
	public Boolean renameNode(String newName, Integer nodeId);
	public Article queryArticle(Integer nodeId);
}