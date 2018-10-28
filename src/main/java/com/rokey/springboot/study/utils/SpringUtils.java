package com.rokey.springboot.study.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenyuejun
 * @date 2018-04-11 下午10:59
 **/
@Component
public class SpringUtils implements ApplicationContextAware {


	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		SpringUtils.applicationContext = applicationContext;
	}

	public static <T> T getBean(String beanName) {

		if (applicationContext.containsBean(beanName)) {

			return (T) applicationContext.getBean(beanName);
		}
		return null;
	}
}