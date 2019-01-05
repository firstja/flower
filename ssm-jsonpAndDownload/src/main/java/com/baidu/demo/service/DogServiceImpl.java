package com.baidu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.demo.mapper.DogMapper;
import com.baidu.demo.pojo.Dog;

/**
 * Dog实体服务的具体实现
 * @author asus
 *
 */
@Service
public class DogServiceImpl implements DogService{

	@Resource
	private DogMapper dogMapper;
	@Override
	public int deleteByPrimaryKey(Integer dId) {
		return dogMapper.deleteByPrimaryKey(dId);
	}

	/**
	 * 设置隔离级别
	 * 当出现运行时异常时会提交失败
	 */
	@Transactional(isolation=Isolation.REPEATABLE_READ,rollbackFor= {RuntimeException.class,Exception.class})
	@Override
	public int insert(Dog record) {
		dogMapper.insert(record);
		
		System.out.println(1/0);//如果出现异常,都不会被提交,事务管理
		dogMapper.insert(new Dog(null,"0",null));
		return 1;
	}

	@Override
	public Dog selectByPrimaryKey(Integer dId) {
		return dogMapper.selectByPrimaryKey(dId);
	}

	@Override
	public List<Dog> selectAll() {
		return dogMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Dog record) {
		return dogMapper.updateByPrimaryKey(record);
	}
	
}
