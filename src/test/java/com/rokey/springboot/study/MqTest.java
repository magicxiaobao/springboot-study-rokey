package com.rokey.springboot.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rokey.springboot.study.mq.Sender;

/**
 * @author chenyuejun
 * @date 2018-04-12 上午11:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {

	@Autowired
	private Sender sender;

	@Test
	public void sendTest() {

		sender.send();
	}
}