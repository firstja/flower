package com.baidu.demo.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 初始化容器
 * 
 * @author asus
 *
 */
//扩展自Abstrac~Initializer的任意类，都会自动地配置Dispatcher-Servlet和Spring应用上下文
//spring的应用上下文会位于程序的Servlet上下文之中
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//	我们创建的SpittrWebAppInitializer这个类是继承了
//	AbstractAnnotationConfigDispatcherServletInitializer，
//	任意继承自这个类的类都会自动的配置Dispatcher-Servlet和Spring应用上下文*，
//	但是真正完成配置上下文的是WebApplicationInitializer的类

	@Override // 应用程序的上下文
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override // web上下文
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override //
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// 如果需要配置过滤器
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		//设置字符集
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] {encodingFilter};
	}
	

}
