package com.rokey.springboot.study.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMq 配置
 * 配置队列，交换器，路由
 * @author chenyuejun
 * @date 2018-04-12 上午11:33
 **/
@Configuration
public class RabbitConfig {


	@Bean
	public Queue helloQueue() {

		return new Queue("hello");
	}

}