package com.rokey.springboot.study;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.rokey.springboot.study.mybatis.entity.User;
import com.rokey.springboot.study.mybatis.entity.UserMapper;

/**
 * @author chenyuejun
 * @date 2018-04-09 下午10:43
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	@Autowired
	private UserMapper userMapper;

	@Before
	public void setUp() {

	}

	@Test
	public void test() {

		userMapper.insert("xiaobao", 3);

		Assert.assertEquals(3, userMapper.findByName("xiaobao").getAge().intValue());

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", "suisui");
		params.put("age", 34);

		userMapper.insertByMap(params);
		Assert.assertEquals(34, userMapper.findByName("suisui").getAge().intValue());

		User guoguo = new User("guoguo", 6);
		userMapper.insertByUser(guoguo);
		Assert.assertEquals(6, userMapper.findByName("guoguo").getAge().intValue());

		User xiaobao = userMapper.findByName("xiaobao");
		xiaobao.setAge(31);
		userMapper.updateAgeByName(xiaobao);
		Assert.assertEquals(31, userMapper.findByName("xiaobao").getAge().intValue());

		userMapper.delete(userMapper.findByName("guoguo"));
		Assert.assertEquals(null, userMapper.findByName("guoguo"));

		List<User> all = userMapper.findAll();
		all.forEach(user -> Assert.assertEquals(null, user.getId()));

	}

}