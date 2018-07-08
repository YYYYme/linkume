package com.cn.linkume.service;

import java.util.List;

import com.cn.linkume.pojo.Article;
import com.cn.linkume.pojo.Content;


public interface ArticleService {  
    public List<Article> findByPid(Integer pid);  
    public List<Article> findById(Integer id);
	public Article addNode(String name, Integer nodeId);  
	public Boolean removeNode(Integer nodeId);
	public Boolean renameNode(String newName, Integer nodeId);
	public Article queryArticle(Integer nodeId);
	public Content selectByArticleId(Integer nodeId);
	public void updateContent(Integer nodeId, String content);
	public void insertContent(Integer nodeId, String content);
}