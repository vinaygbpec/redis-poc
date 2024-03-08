package com.iag.redis.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class RedisDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
}
