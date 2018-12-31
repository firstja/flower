package com.baidu.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * web上下文的相关配置
 * @author asus
 *
 */

@Configuration  //定义一个配置类
@ComponentScan(basePackages= {"com.baidu.ssm.controller"})
@EnableWebMvc //开启webmvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 配置视图解析器
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//设置前缀
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//还有一种封装的更深的方式
	

	
	/**
	 * 
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();//开启
	}
	
	/**
	 * 文件上传:前提:有fileupload 
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		//设置默认的字符集
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(1024*1024*10);//10M
		return multipartResolver;
	}
	
	//如果需要注册拦截器
	//interceptor
	
}
