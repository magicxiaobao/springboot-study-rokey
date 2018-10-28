package com.rokey.springboot.study.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.rokey.springboot.study.entity.User;
import com.rokey.springboot.study.jpa.Worker;



/**
 * @author chenyuejun
 */
@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		return new JedisConnectionFactory();
	}


	@Bean
	RedisTemplate<String, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

		RedisTemplate<String, User> stringUserRedisTemplate = new RedisTemplate<>();
		stringUserRedisTemplate.setConnectionFactory(redisConnectionFactory);
		stringUserRedisTemplate.setKeySerializer(new StringRedisSerializer());
		stringUserRedisTemplate.setValueSerializer(new RedisObjectSerializer());
		return stringUserRedisTemplate;

	}

	@Bean
	RedisTemplate<String, Worker> workerRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

		RedisTemplate<String, Worker> stringWorkeredisTemplate = new RedisTemplate<>();
		stringWorkeredisTemplate.setConnectionFactory(redisConnectionFactory);
		stringWorkeredisTemplate.setKeySerializer(new StringRedisSerializer());
		stringWorkeredisTemplate.setValueSerializer(new RedisObjectSerializer());
		return stringWorkeredisTemplate;
	}

}
