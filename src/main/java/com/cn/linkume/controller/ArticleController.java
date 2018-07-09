package com.cn.linkume.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.linkume.pojo.Article;
import com.cn.linkume.pojo.Content;
import com.cn.linkume.service.ArticleService;
import com.cn.linkume.vo.AjaxResultVo;

/**
 * 作品管理类
 */
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
	public AjaxResultVo addNode(String name ,Integer nodeId) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		// 获取根节点（获取的值存到list中）
		Article article = articleService.addNode(name, nodeId);
		ajaxResultVo.setData(article);
		ajaxResultVo.setRet(true);
		return ajaxResultVo;
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

	/**
	 * 获取节点详情
	 */
	@RequestMapping(value = "/getNodeInfo", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResultVo getNodeInfoById(Integer nodeId) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		// 获取根节点（获取的值存到list中）
		Article article = articleService.queryArticle(nodeId);
		ajaxResultVo.setData(article);
		ajaxResultVo.setRet(true);
		return ajaxResultVo;
	}
	/**
	 * 获取文章内容
	 */
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResultVo selectByArticleId(Integer nodeId) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		Content content = articleService.selectByArticleId(nodeId);
		String result = "";
		if (null != content) {
			result = content.getContent();
		}
		/*try {
			if (null != content) {
				//result = ConvertUtil.bytesToObject(content.getContent()).toString();
				result = content.getContent();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		ajaxResultVo.setData(result);
		ajaxResultVo.setRet(true);
		return ajaxResultVo;
	}
	/**
	 * 插入或修改文章
	 */
	@RequestMapping(value = "/upsertContent", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResultVo upsertContent(Integer nodeId, String content) {
		AjaxResultVo ajaxResultVo = new AjaxResultVo();
		//查询是否已有articleId
		Content contentResult = articleService.selectByArticleId(nodeId);
		if (null != contentResult) {
			articleService.updateContent(nodeId, content);
		} else {
			articleService.insertContent(nodeId, content);
		}
		ajaxResultVo.setRet(true);
		return ajaxResultVo;
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