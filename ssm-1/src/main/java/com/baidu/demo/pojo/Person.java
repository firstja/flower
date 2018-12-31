package com.baidu.demo.pojo;

public class Person {
	private Integer p_id;
	private String p_name;
	private Integer p_age;
	public Person(Integer p_id, String p_name, Integer p_age) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_age = p_age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Integer getP_age() {
		return p_age;
	}
	public void setP_age(Integer p_age) {
		this.p_age = p_age;
	}
	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", p_name=" + p_name + ", p_age=" + p_age + "]";
	}
	
	
}
