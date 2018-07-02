package com.cn.linkume.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.linkume.dao.ArticleDao;
import com.cn.linkume.pojo.Article;
import com.cn.linkume.service.ArticleService;

@Service("articleServiceImpl")  
public class ArticleServiceImpl implements ArticleService{  
  
    @Autowired  
    private ArticleDao articleDao;  
      
    @Override  
    public List<Article> findByPid(Integer pid) {     
        return articleDao.selectByPid(pid);  
    }  
  
    @Override  
    public List<Article> findById(Integer id) {  
        return articleDao.selectByPrimaryKey(id);  
    }

	@Override
	public Boolean addNode(String name, Integer nodeId) {
		Article article = new Article();
		article.setPid(nodeId);
		article.setText(name);
		articleDao.insertArticle(article);
		return true;
	}  
  
}