package com.rokey.springboot.study.log;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import com.rokey.springboot.study.utils.SpringUtils;

/**
 * @author chenyuejun
 * @date 2018-04-11 下午10:57
 **/
public class MongoAppender extends AppenderSkeleton {

	private static Logger logger = Logger.getLogger(MongoAppender.class);

	@Override
	protected void append(LoggingEvent event) {

		MongoLogRepository mongoLogRepository = (MongoLogRepository)SpringUtils.getBean("mongoLogRepository");
		if (mongoLogRepository != null) {

			Object message = event.getMessage();
			logger.debug("message: " + message.toString());
			mongoLogRepository.insert((MongoLog) event.getMessage());
			logger.info("test actuator change log level");
		} else {

			System.out.println("mongodbRepository haven't initialed");
		}

	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	public void close() {

	}
}