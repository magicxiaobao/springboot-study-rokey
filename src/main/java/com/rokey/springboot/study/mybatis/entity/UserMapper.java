package com.rokey.springboot.study.mybatis.entity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author chenyuejun
 * @date 2018-04-09 下午10:37
 **/
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user WHERE name = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Insert("INSERT INTO user(name, age) VALUES(#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> params);

	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
	int insertByUser(User user);

	@Update("UPDATE user SET age = #{age} WHERE name = #{name}")
	void updateAgeByName(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	void delete(User user);

	@Results({@Result(property = "name",column = "name"),@Result(property = "age", column = "age")})
	@Select("SELECT name, age FROM user")
	List<User> findAll();

}