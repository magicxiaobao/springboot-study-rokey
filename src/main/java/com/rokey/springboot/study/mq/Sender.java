package com.rokey.springboot.study.mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenyuejun
 * @date 2018-04-12 上午11:25
 **/
@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;


	public void send() {

		String msg = "hello" + new Date();

		this.rabbitTemplate.convertAndSend("hello", msg);
	}

}