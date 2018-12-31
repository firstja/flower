package com.baidu.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Dog {
    private Integer dId;

    private String dName;

    private Integer dAge;
    
    //日期赋值格式
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    
    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdAge() {
        return dAge;
    }

    public void setdAge(Integer dAge) {
        this.dAge = dAge;
    }
}