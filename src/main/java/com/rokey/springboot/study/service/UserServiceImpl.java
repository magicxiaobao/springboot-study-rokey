package com.rokey.springboot.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午11:24
 **/
@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createUser(String name, Integer age) {

		jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?) ", name, age);
	}

	@Override
	public void deleteByName(String name) {

		jdbcTemplate.update("delete from USER where name = ?", name);
	}

	@Override
	public Integer countAllUsers() {

		return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
	}

	@Override
	public void deleteAllUsers() {

		jdbcTemplate.update("delete from USER");
	}
}