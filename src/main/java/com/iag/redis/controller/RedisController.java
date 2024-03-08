package com.iag.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iag.redis.dto.RedisDto;
import com.iag.redis.service.MyRedisService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/")
@Slf4j
public class RedisController {
	@Autowired
	private MyRedisService myRedisService;
	
	@PostMapping("/redis")
	public ResponseEntity<Object> setValue(@RequestBody RedisDto redis) {
		try {		
			myRedisService.storeEntry(redis.getKey(), redis);
			
			return new ResponseEntity<>("ok", HttpStatus.OK);

		} catch (Exception e) {
			log.error("exception in send sms api", e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/redisget")
	public ResponseEntity<Object> getValue(@RequestParam String key) {
		try {		
			RedisDto redis=(RedisDto)myRedisService.getEntry(key);
			
			return new ResponseEntity<>(redis, HttpStatus.OK);

		} catch (Exception e) {
			log.error("exception in send sms api", e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
