package com.rokey.springboot.study;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author chenyuejun
 * @date 2018-04-09 上午10:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MultiDataSourceTest {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate secondaryJdbcTemplate;

	@Before
	public void setUp() {

		primaryJdbcTemplate.update("DELETE FROM USER");
		secondaryJdbcTemplate.update("DELETE FROM USER");
	}

	@Test
	public void test() {

		primaryJdbcTemplate.update("INSERT INTO user (id,name,age) values(?,?,?)",1, "aaa", 20);
		primaryJdbcTemplate.update("INSERT INTO user(id,name,age) values(?,?,?)", 2, "bbb", 30);

		secondaryJdbcTemplate.update("INSERT INTO user (id,name,age) values(?,?,?)",1,"aaa",20);

		Assert.assertEquals(2, primaryJdbcTemplate.queryForObject("SELECT COUNT(1) FROM user",String.class));

		Assert.assertEquals(1, secondaryJdbcTemplate.queryForObject("SELECT COUNT(1) FROM user",String.class));

	}

}