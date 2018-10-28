package com.rokey.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenyuejun
 * @date 2018-04-06 下午8:31
 **/
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String index() {

		return "hello";
	}
}