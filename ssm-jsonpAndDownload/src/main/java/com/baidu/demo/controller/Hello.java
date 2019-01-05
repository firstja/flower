package com.baidu.demo.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.demo.pojo.Dog;
import com.baidu.demo.service.DogService;

@Controller  //控制器
@RequestMapping("/test")
public class Hello {

	/**
	 * 初始化一个赋值建议
	 */
	@InitBinder
	public void initBinder(DataBinder dataBinder) {
		dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
		
	}
	
	@Autowired
	private DogService dogService;
	
	
	@RequestMapping("/hello")
	public String hello() {
		//System.out.println("你好");
		return "hello";
	}
	
	
	 /**
	  * java对象序列化为json字符串,前提:添加了jackson jar包
	  */
	@RequestMapping("/json1")
//	@GetMapping
	@ResponseBody  //标识方法为返回数据,
	public ModelAndView testJson(ModelAndView modelAndView,Integer dId) {//如果不是特殊的类型,自动封装
		//添加数据和视图
		Dog dog=dogService.selectByPrimaryKey(dId);
		modelAndView.addObject("dog", dog);
		modelAndView.setViewName("dogInfo");//返回的文件名
		return modelAndView;
	}
	
	//转换为xml格式
	//前提:将pojo 的类和set方法上使用注解
	@RequestMapping("/xml1")
	@ResponseBody
	public Dog testXml1(@Param(value = "dId") int dId) {
		Dog dog=dogService.selectByPrimaryKey(dId);
		return dog;
	}
	
	/**
	 * 文件的上传,前提,设置了upload 组建;
	 */
	@RequestMapping("/upload")
	public ModelAndView upload1(ModelAndView modelAndView,MultipartFile file,HttpServletRequest request) {
		//获取文件名
		String filename=file.getOriginalFilename();
		//重构方法名
		filename=UUID.randomUUID()+"_"+filename;
		//获取文件存储的路径
		String path=request.getServletContext().getRealPath("download");
		//
	}
	
	
}
