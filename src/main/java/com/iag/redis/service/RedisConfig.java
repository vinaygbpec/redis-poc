package com.iag.redis.service;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {


	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration("localhost", 6379);
		redisStandaloneConfig.setPassword(RedisPassword.of("default"));

		return new JedisConnectionFactory(redisStandaloneConfig);
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Serializable> redisTemplate() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());

		return template;
	}
}
