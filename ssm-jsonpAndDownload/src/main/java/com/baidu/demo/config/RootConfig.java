package com.baidu.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 应用上下文的配置
 * @author asus
 *
 */
@Configuration  //定义一个配置类
@Import(DataConfig.class)//导入一个配置类
@ComponentScan(basePackages= {"com.baidu.demo"},
excludeFilters=@Filter(type=FilterType.ANNOTATION,classes=EnableWebMvc.class))
public class RootConfig {
	
	
	
}
