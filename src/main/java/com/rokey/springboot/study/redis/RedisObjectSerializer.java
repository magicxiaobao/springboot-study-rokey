package com.rokey.springboot.study.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;



/**
 * @author chenyuejun
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {


	private Converter<Object, byte[]> serializer = new SerializingConverter();

	private Converter<byte[], Object> deSerializer = new DeserializingConverter();

	static final byte[] EMPTY_ARRAY = new byte[0];

	@Override
	public byte[] serialize(Object o) {

		if (o == null) {

			return EMPTY_ARRAY;
		}
		return serializer.convert(o);
	}

	@Override
	public Object deserialize(byte[] bytes) {

		if (isEmpty(bytes)) {

			return null;
		}
		return deSerializer.convert(bytes);
	}

	private boolean isEmpty(byte[] bytes) {

		return bytes == null || bytes.length == 0;
	}
}
