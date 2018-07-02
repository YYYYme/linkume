package com.cn.linkume.controller;

import java.io.UnsupportedEncodingException;
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
	// 此注解表明返回值跳过视图处理部分，直接写入 http response body中
	public List<Article> getTree() {
		List<Article> root = articleService.findById(0); // 获取根节点（获取的值存到list中）
		// JSONArray jsonArray = JSONArray.toJSON(buildTree(root));
		// System.out.println(jsonArray.toString());

		return buildTree(root);
	}
	/**
	 * 增加节点
	 */
	@RequestMapping(value = "/addNode", method = RequestMethod.GET)
	@ResponseBody
	// 此注解表明返回值跳过视图处理部分，直接写入 http response body中
	public Boolean addNode(String name ,Integer nodeId) {
		Boolean result = articleService.addNode(name, nodeId); // 获取根节点（获取的值存到list中）
		return result;
	}

	public List<Article> buildTree(List<Article> root) {
		for (int i = 0; i < root.size(); i++) {
			List<Article> children = articleService.findByPid(root.get(i)
					.getId()); // 查询某节点的子节点（获取的是list）
			buildTree(children);
			root.get(i).setChildren(children);
		}
		return root;
	}

}