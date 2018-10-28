package com.rokey.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午8:28
 **/
@Controller
public class LoginController {


	@RequestMapping(value = "/login")
	public String loginPage() {

		return "login";
	}

}