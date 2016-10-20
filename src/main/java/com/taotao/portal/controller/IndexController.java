package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.service.ContentService;


/**
 * 首页
 * @author 浮生若梦
 * 2016年10月14日 下午4:34:14
 */
@Controller
public class IndexController {
	@Autowired
	private ContentService contentServiceImpl;
	
	/**
	 * 门户首页
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String showIndex(Model model){
		String jsonStr = contentServiceImpl.getContentList();
		model.addAttribute("ad1", jsonStr);
		return "index";
	}
	
	/**
	 * 测试post请求
	 * @return
	 */
	@RequestMapping(value="/httpclient/post",method=RequestMethod.POST)
	@ResponseBody
	public String getPost(String username,String password){
		return "username:"+username+" password:"+password;
	}
	
	
}
