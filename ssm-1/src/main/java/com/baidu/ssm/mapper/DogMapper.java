package com.baidu.ssm.mapper;

import com.baidu.ssm.pojo.Dog;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Mapper     //Mybatis的spring-mybatis
//@Scope
//@Lazy
public interface DogMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dog record);

    Dog selectByPrimaryKey(Integer dId);

    List<Dog> selectAll();

    int updateByPrimaryKey(Dog record);
}