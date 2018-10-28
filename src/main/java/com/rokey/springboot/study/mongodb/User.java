package com.rokey.springboot.study.mongodb;

import org.springframework.data.annotation.Id;

/**
 * @author chenyuejun
 * @date 2018-04-09 下午9:06
 **/
public class User {

	@Id
	private Long id;

	private String name;

	private Integer age;

	public User(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}