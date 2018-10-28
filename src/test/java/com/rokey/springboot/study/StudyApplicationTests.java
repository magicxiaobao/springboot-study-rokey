package com.rokey.springboot.study;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rokey.springboot.study.controller.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StudyApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() {

		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	/*@Test
	public void getHello() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Hello World!")));
	}*/

}
