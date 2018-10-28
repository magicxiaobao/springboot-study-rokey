package com.rokey.springboot.study.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 *
 * @author chenyuejun
 * @date 2018-04-07 下午3:56
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> myExceptionHandler(HttpServletRequest req, Exception ex) {

		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setCode(ErrorInfo.FAIL);
		errorInfo.setData("some data");
		errorInfo.setMsg(ex.getMessage());
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;
	}
}