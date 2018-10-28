package com.rokey.springboot.study.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chenyuejun
 * @date 2018-04-12 上午11:31
 **/
@Component
@RabbitListener(queues = "hello")
public class Consumer {


	@RabbitHandler
	public void process(String msg) {

		System.out.println("Reeiver : " + msg);
	}
}