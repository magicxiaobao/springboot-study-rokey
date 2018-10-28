package com.rokey.springboot.study.log;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author chenyuejun
 * @date 2018-04-11 下午10:55
 **/
public interface MongoLogRepository extends MongoRepository<MongoLog, Long> {



}