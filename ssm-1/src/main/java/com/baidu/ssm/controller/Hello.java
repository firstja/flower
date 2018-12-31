package com.baidu.ssm.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Hello {
	
	//初始化一个赋值建议
	@InitBinder
	public void initbinder(DataBinder dataBinder) {
		dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("你好");
		return "hello";
	}
	
}
