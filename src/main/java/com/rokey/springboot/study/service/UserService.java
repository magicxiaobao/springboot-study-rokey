package com.rokey.springboot.study.service;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午11:23
 **/
public interface UserService {


	void createUser(String name, Integer age);

	void deleteByName(String name);

	Integer countAllUsers();

	void deleteAllUsers();

}