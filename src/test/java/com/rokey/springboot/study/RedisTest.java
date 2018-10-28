package com.rokey.springboot.study;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.rokey.springboot.study.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> userRedisTemplate;

	@Test
	public void test() {

		stringRedisTemplate.opsForValue().set("suisui","zhonghang");

		Assert.assertEquals("zhonghang", stringRedisTemplate.opsForValue().get("suisui"));

		User xiaobao = new User("xiaobao", 31);
		userRedisTemplate.opsForValue().set(xiaobao.getName(), xiaobao);

		User suisui = new User("suisui", 34);
		userRedisTemplate.opsForValue().set(suisui.getName(), suisui);

		User guoguo = new User("guoguo", 6);
		userRedisTemplate.opsForValue().set(guoguo.getName(), guoguo);

		Assert.assertEquals(31, userRedisTemplate.opsForValue().get("xiaobao").getAge().intValue());
		Assert.assertEquals(34, userRedisTemplate.opsForValue().get("suisui").getAge().intValue());
		Assert.assertEquals(6, userRedisTemplate.opsForValue().get("guoguo").getAge().intValue());

	}

}
