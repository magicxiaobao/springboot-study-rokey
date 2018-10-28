package com.rokey.springboot.study.log;

import org.springframework.data.annotation.Id;

/**
 * @author chenyuejun
 * @date 2018-04-11 下午10:46
 **/
public class MongoLog {

	@Id
	private Long id;

	private String url;

	private String httpMethod;

	private String ip;

	private String classMethod;

	private String args;

	public MongoLog() {
	}

	public MongoLog(Long id, String url, String httpMethod, String ip, String classMethod, String args) {
		this.id = id;
		this.url = url;
		this.httpMethod = httpMethod;
		this.ip = ip;
		this.classMethod = classMethod;
		this.args = args;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}
}