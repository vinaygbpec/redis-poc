package com.iag.redis.service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRedisService {
	private static final String REDIS_CONNECTION_ERROR_MESSAGE = "Connection to Redis database failed";
	private long timeInMilliSeconds = 3600000;
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	public void storeEntry(String entryKey, Serializable entry) {
		// create the redisHash map and add the serialized entry object in the map
		try {
			redisTemplate.opsForValue().set(entryKey, entry, timeInMilliSeconds, TimeUnit.MILLISECONDS);
		} catch (DataAccessResourceFailureException exception) {
			exception.printStackTrace();
		}
	}
	
	public Serializable getEntry(String entryKey) {
		// create the redisHash map and add the serialized entry object in the map
		try {
			return redisTemplate.opsForValue().get(entryKey);
		} catch (DataAccessResourceFailureException exception) {
			exception.printStackTrace();
		}
		return null;
	}

}