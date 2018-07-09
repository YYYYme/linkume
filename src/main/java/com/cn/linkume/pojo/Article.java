package com.cn.linkume.pojo;

import java.util.List;

/**
 * 文章树
 *
 * @author Administrator
 */
public class Article {
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 部门名称
     */
    private String text;
    /**
     * 节点级别
     */
    private Integer level;
    /**
     * 用于存储子节点
      */
    private List<Article> children;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

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