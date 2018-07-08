package com.cn.linkume.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.linkume.dao.ArticleDao;
import com.cn.linkume.dao.ContentDao;
import com.cn.linkume.pojo.Article;
import com.cn.linkume.pojo.Content;
import com.cn.linkume.service.ArticleService;

@Service("articleServiceImpl")  
public class ArticleServiceImpl implements ArticleService{  
  
    @Autowired  
    private ArticleDao articleDao;  
    @Autowired  
    private ContentDao contentDao;  
      
    @Override  
    public List<Article> findByPid(Integer pid) {     
        return articleDao.selectByPid(pid);  
    }  
  
    @Override  
    public List<Article> findById(Integer id) {  
        return articleDao.selectListByPrimaryKey(id);
    }

	@Override
	public Article addNode(String name, Integer nodeId) {
		Article article = new Article();
		article.setPid(nodeId);
		article.setText(name);
        int level = queryArticle(nodeId).getLevel() + 1;
        article.setLevel(level);
        int id = articleDao.insertArticle(article);
		return article;
	}

    @Override
    public Boolean removeNode(Integer nodeId) {

        articleDao.deleteByPrimaryKey(nodeId);
        return true;
    }

    @Override
    public Boolean renameNode(String newName, Integer nodeId) {
        Article article = new Article();
        article.setId(nodeId);
        article.setText(newName);
        articleDao.updateByPrimaryKeySelective(article);
        return true;
    }

    @Override
    public Article queryArticle(Integer nodeId) {
        Article article = articleDao.selectByPrimaryKey(nodeId);
        return article;
    }

	@Override
	public Content selectByArticleId(Integer nodeId) {
		Content content = contentDao.selectByArticleId(nodeId);
		return content;
	}

	@Override
	public void updateContent(Integer nodeId, String content) {
		Content cont = new Content();
		cont.setArticleId(nodeId);
		cont.setContent(content);
		/*try {
			cont.setContent(ConvertUtil.objectToBytes(content));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		contentDao.updateByArticleId(cont);
	}

	@Override
	public void insertContent(Integer nodeId, String content) {
		Content cont = new Content();
		cont.setArticleId(nodeId);
		cont.setContent(content);
		/*try {
			cont.setContent(ConvertUtil.objectToBytes(content));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		contentDao.insertContent(cont);
	}

}