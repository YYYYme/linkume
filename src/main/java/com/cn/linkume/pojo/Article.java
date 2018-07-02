package com.cn.linkume.pojo;

import java.util.List;

/** 
 * 部门类 用户所属部门（这里的部门是一个相对抽象的词） 
 * 使用前缀编码，每级增加三个数字，如：第一级 001，第二级001001，第三级001001001 
 * @author Administrator 
 * 
 */  
public class Article {  
     
    private Integer id;          //部门id   
    private Integer pid;         //父id  
    private String text;        //部门名称  
    private List<Article> children;   //用于存储子节点  
      
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getText() {  
        return text;  
    }  
    public void setText(String text) {  
        this.text = text;  
    }  
    public List<Article> getChildren() {  
        return children;  
    }  
    public void setChildren(List<Article> children) {  
        this.children = children;  
    }      
      
}