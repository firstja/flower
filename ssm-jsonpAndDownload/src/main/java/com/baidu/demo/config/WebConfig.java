package com.baidu.demo.config;

import javax.swing.text.View;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;

/**
 * web上下文的配置
 * @author asus
 *
 */
@Configuration //定义一个配置类
@ComponentScan(basePackages= {"com.baidu.demo.controller"})
@EnableWebMvc //开启web mvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 配置JSP视图解析器，他会查找jsp文件，
	 * 在查找的时候 他会在视图名称上加一个特定的前缀和后缀
	 * home的视图——解析成为/home.jsp
	 * 
	 * @return
	 */
	//视图解析器
	@Bean 
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	/**
     * 通过调用enable方法，我们要求DispatcherServelet将
     * 对静态资源的请求转发到Servlet容器中的默认的Servlet上，
     * 不是DispatcherServelet本身处理
     * @param configurer
     */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();//开启
	}
	
	/**
	 * 配置上传文件组件
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		//设置默认的字符集
		multipartResolver.setDefaultEncoding("utf-8");
		//设置上传文件的最大值
		multipartResolver.setMaxUploadSize(1024*1024*10);
		return multipartResolver;
	}
	
	//如果需要配置拦截器,
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
	}
	
}
