package com.baidu.demo.service;

import java.util.List;

import com.baidu.demo.pojo.Dog;

/**
 * Dog实体具体服务实现的标准
 * @author asus
 *
 */
public interface DogService {
	/**
	 * 根据dog编号删除对应的dog
	 * @param dId
	 * @return
	 */
	int deleteByPrimaryKey(Integer dId);

	/**
	 * 新增一个dog对象
	 * @param record
	 * @return
	 */
    int insert(Dog record);

    /*
     * 根据dog编号查询对应的dog
     */
    Dog selectByPrimaryKey(Integer dId);

    /**
     * 获取所有的dog信息
     * @return
     */
    List<Dog> selectAll();

    /**
     * 根据dog编号修改dog信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dog record);
}
