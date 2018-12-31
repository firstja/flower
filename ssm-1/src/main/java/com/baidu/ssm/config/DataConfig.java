package com.baidu.ssm.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据源的配置
 * @author asus
 *
 */
@Configuration //配置类
@MapperScan(basePackages= {"com.baidu.ssm.mapper"})
@PropertySource("classpath:ds.properties")//将配置文件内容读取到environment
@EnableTransactionManagement  //开启事物管理
public class DataConfig {
	@Resource
	private Environment environment;
	
	/**
	 * 定义数据源
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("db.username"));
		basicDataSource.setPassword(environment.getProperty("password"));
		basicDataSource.setUrl(environment.getProperty("url"));
		basicDataSource.setDriverClassName(environment.getProperty("driver"));
		return basicDataSource;
	}
	
	/**
	 * 定义事物管理
	 */
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * 托管SqlSessionFactory 
	 */
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		//设置数据源
		sessionFactoryBean.setDataSource(dataSource);
		//设置别名
		sessionFactoryBean.setTypeAliasesPackage("com.baidu.ssm.pojo");
		return sessionFactoryBean;
	}

}
