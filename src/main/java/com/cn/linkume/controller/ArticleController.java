package com.cn.linkume.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.linkume.pojo.Article;
import com.cn.linkume.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	/**
	 * 获取文章树形列表
	 */
	@RequestMapping(value = "/getTree", method = RequestMethod.GET)
	@ResponseBody
	public List<Article> getTree() {
		// 获取根节点（获取的值存到list中）
		List<Article> root = articleService.findById(0);
		return buildTree(root);
	}
	/**
	 * 增加节点
	 */
	@RequestMapping(value = "/addNode", method = RequestMethod.GET)
	@ResponseBody
	public Boolean addNode(String name ,Integer nodeId) {
		// 获取根节点（获取的值存到list中）
		Boolean result = articleService.addNode(name, nodeId);
		return result;
	}
	/**
	 * 删除节点
	 */
	@RequestMapping(value = "/removeNode", method = RequestMethod.GET)
	@ResponseBody
	public Boolean removeNode(Integer nodeId) {
		// 获取根节点（获取的值存到list中）
		Boolean result = articleService.removeNode(nodeId);
		return result;
	}
	/**
	 * 重命名节点
	 */
	@RequestMapping(value = "/renameNode", method = RequestMethod.GET)
	@ResponseBody
	public Boolean renameNode(String newName, Integer nodeId) {
		// 获取根节点（获取的值存到list中）
		Boolean result = articleService.renameNode(newName, nodeId);
		return result;
	}

	public List<Article> buildTree(List<Article> root) {
		for (int i = 0; i < root.size(); i++) {
			// 查询某节点的子节点（获取的是list）
			List<Article> children = articleService.findByPid(root.get(i)
					.getId());
			buildTree(children);
			root.get(i).setChildren(children);
		}
		return root;
	}

}