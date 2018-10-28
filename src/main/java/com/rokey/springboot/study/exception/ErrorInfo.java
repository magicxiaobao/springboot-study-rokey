package com.rokey.springboot.study.exception;

/**
 * @author chenyuejun
 * @date 2018-04-07 下午4:10
 **/
public class ErrorInfo<T> {

	public static final Integer SUCCESS = 0;

	public static final Integer FAIL = 100;

	private Integer code;

	private String msg;

	private T data;

	private String url;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ErrorInfo{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}
}