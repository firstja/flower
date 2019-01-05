package com.baidu.demo.mapper;

import com.baidu.demo.pojo.Dog;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dog record);

    Dog selectByPrimaryKey(Integer dId);

    List<Dog> selectAll();

    int updateByPrimaryKey(Dog record);
}