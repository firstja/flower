package com.baidu.demo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring整合mybatis持久层框架
 * @author asus
 *
 */
@Configuration //定义一个配置类
@MapperScan(basePackages= {"com.baidu.demo.mapper"})
@PropertySource("classpath:ds.properties")//将属性集中的内容读取到environment中
@EnableTransactionManagement //开启事务管理
public class DataConfig {
	@Resource  //自动注入,java的注解,
//	@Qualifier //当注入的类型,有多个实现的时候,可以通过Qualifier也标注是bean
//	@Autowired //自动注入,作用和Resource相似
	private org.springframework.core.env.Environment environment;
	
	/**
	 * 定义数据源
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource=new BasicDataSource();
		//设置basicDataSource的属性
		basicDataSource.setUsername(environment.getProperty("db.username"));
		basicDataSource.setPassword(environment.getProperty("password"));
		basicDataSource.setUrl(environment.getProperty("url"));
		basicDataSource.setDriverClassName(environment.getProperty("driver"));
		return basicDataSource;
	}

	/**
	 * 数据源的事务管理
	 */
	@Bean //多态:一种行为的多种实现
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * sqlSessionFactory托管
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		//设置别名
		sqlSessionFactoryBean.setTypeAliasesPackage("com.baidu.demo.pojo");
		//如果需要引入外部的xml文件,可以进行设置
		//设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}
	

	
}
