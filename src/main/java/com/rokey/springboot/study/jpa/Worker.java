package com.rokey.springboot.study.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午11:59
 **/
@Entity
public class Worker implements Serializable {

	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 8)
	private String name;

	@Column(nullable = false)
	private Integer age;

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

	public Worker(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Worker() { }
}