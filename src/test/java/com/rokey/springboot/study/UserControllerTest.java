package com.rokey.springboot.study;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rokey.springboot.study.controller.UserController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午1:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() {

		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {

		RequestBuilder request = null;

		//1.查下user列表，应该返回空
		request = get("/users/");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("[]")));
		//2.post一个User
		request = post("/users/")
			.param("id", "1")
			.param("name", "xiaobao")
			.param("age", "31");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("success")));
		//3.get这个user 根据id
		request = get("/users/1");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"xiaobao\",\"age\":31}")));
		//4.更新这个user
		request = put("/users/1")
			.param("age", "6")
			.param("name", "xiaobao");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("success")));
		//5.继续获取这个user
		request = get("/users/1");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"xiaobao\",\"age\":6}")));
		//6.删除这个user
		request = delete("/users/1");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("success")));
		//7.查询user列表，应该返回空
		request = get("/users/");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("[]"));
	}
}