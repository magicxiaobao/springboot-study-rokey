package com.rokey.springboot.study.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rokey.springboot.study.log.MongoLog;


/**
 * @author chenyuejun
 * @date 2018-04-11 下午1:27
 **/
@Aspect
@Component
public class WebLog {

	Logger logger  = Logger.getLogger("mongodb");

	private ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Pointcut("execution(public * com.rokey.springboot.study.controller..*.*(..))")
	public void webLog(){}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {


		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		MongoLog mongoLog = new MongoLog();
		mongoLog.setUrl(request.getRequestURL().toString());
		mongoLog.setId(System.currentTimeMillis());
//		logger.info("url: " + request.getRequestURL().toString());
		logger.info(mongoLog);
	}

	/*@AfterReturning(returning = "ret",pointcut = "webLog()")
	public void doAfterReturning(Object ret) {

		logger.info("RESPONSE: " + ret);
		logger.info("SpendTime: " + (System.currentTimeMillis() - startTime.get()));
	}*/

}