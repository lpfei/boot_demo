package com.example.config.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * spring session支持
 * Created by lpfei on 2017/3/30.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
