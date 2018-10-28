package com.rokey.springboot.study.exception;

/**
 * 自定义异常
 * @author chenyuejun
 * @date 2018-04-07 下午4:14
 **/
public class MyException extends RuntimeException{

	public MyException(String message) {
		super(message);
	}
}