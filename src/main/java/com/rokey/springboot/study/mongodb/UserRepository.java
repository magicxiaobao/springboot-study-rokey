package com.rokey.springboot.study.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author chenyuejun
 * @date 2018-04-09 下午9:07
 **/
public interface UserRepository extends MongoRepository<User, Long> {


	User findByName(String name);

}