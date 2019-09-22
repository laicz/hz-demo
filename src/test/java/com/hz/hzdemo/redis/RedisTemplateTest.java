//package com.hz.hzdemo.redis;
//
//import com.hz.hzdemo.HzDemoApplication;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Create by zhoumingbing on 2019-05-16
// */
//@ContextConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = HzDemoApplication.class)
//public class RedisTemplateTest {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void init() {
//        redisTemplate.opsForValue().set("key1", "value1");
//    }
//
//    @Test
//    public void testCacheable() {
//        cacheable("test_name");
//    }
//
//    @Cacheable(cacheNames = "test:test1:test2", key = "#p0")
//    public void cacheable(String name) {
//        System.out.println(name);
//    }
//
//}
