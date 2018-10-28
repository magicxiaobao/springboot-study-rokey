package com.rokey.springboot.study.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rokey.springboot.study.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author chenyuejun
 * @date 2018-04-06 下午10:33
 **/

@RestController
@RequestMapping(value = "/users")
public class UserController {

	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUserList() {

		List<User> userList = new ArrayList<>(UserController.users.values());
		return userList;
	}

	@ApiOperation(value = "新增用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {

		users.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "查询单个用户", notes = "根据id查询单个用户")
	@ApiImplicitParam(name = "id", value = "用户实体的id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {

		return users.get(id);
	}

	@ApiOperation(value = "更新用户", notes = "更新单个用户")
	@ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long"),
					   @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String"),
					   @ApiImplicitParam(name = "age", value = "用户年龄", dataType = "Long")})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user) {

		User sourceUser = users.get(id);
		sourceUser.setName(user.getName());
		sourceUser.setAge(user.getAge());
		users.put(id, sourceUser);
		return "success";
	}

	@ApiOperation(value = "删除yonghu", notes = "根据url中的id删除用户对象")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {

		users.remove(id);
		return "success";
	}
}