package com.rokey.springboot.study;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rokey.springboot.study.mongodb.User;
import com.rokey.springboot.study.mongodb.UserRepository;

/**
 * @author chenyuejun
 * @date 2018-04-09 下午9:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {

		userRepository.deleteAll();
	}

	@Test
	public void test() {

		userRepository.save(new User(1L, "xiaobao", 3));
		userRepository.save(new User(2L, "suisui", 4));
		userRepository.save(new User(3L, "guoguo", 5));

		Assert.assertEquals(3, userRepository.findByName("xiaobao").getAge().intValue());

		Assert.assertEquals(3, userRepository.count());

		Optional<User> user = userRepository.findById(3L);
		userRepository.delete(user.get());
		Assert.assertEquals(2, userRepository.findAll().size());
	}

}