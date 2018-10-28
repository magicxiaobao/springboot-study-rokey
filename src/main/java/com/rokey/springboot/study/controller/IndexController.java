package com.rokey.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rokey.springboot.study.exception.MyException;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午2:49
 **/
@Controller
@RequestMapping(value = "/index")
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getView(ModelMap modelMap) {

		modelMap.addAttribute("host", "www.baidu.com");
		return "index";
	}

	@RequestMapping(value = "/testException")
	public String testException() throws Exception {

		throw new Exception("测试异常");
	}

	@RequestMapping(value = "/testMyException")
	public String testMyException() {

		throw new MyException("自定义异常");
	}

}