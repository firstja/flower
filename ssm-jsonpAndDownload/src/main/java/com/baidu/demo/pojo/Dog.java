package com.baidu.demo.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
public class Dog {
    private Integer dId;

    private String dName;

    private Integer dAge;

    public Integer getdId() {
        return dId;
    }
    @XmlElement 
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }
    @XmlElement 
    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdAge() {
        return dAge;
    }
    @XmlElement 
    public void setdAge(Integer dAge) {
        this.dAge = dAge;
    }

	public Dog(Integer dId, String dName, Integer dAge) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dAge = dAge;
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}