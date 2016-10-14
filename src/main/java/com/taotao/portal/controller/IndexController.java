package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author 浮生若梦
 * 2016年10月14日 下午4:34:14
 */
@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}
}
