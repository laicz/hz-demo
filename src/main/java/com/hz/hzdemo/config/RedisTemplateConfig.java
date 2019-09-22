//package com.hz.hzdemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Create by zhoumingbing on 2019-05-16
// */
//@Configuration
//public class RedisTemplateConfig {
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(factory);
//        RedisSerializer redisSerializer =new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        return redisTemplate;
//    }
//
//}
