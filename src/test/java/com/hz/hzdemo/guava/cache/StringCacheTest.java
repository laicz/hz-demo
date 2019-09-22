package com.hz.hzdemo.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by zhoumingbing on 2019-06-05
 */
public class StringCacheTest {

    @Test
    public void cacheBuilder(){
        Cache<String, String> build = CacheBuilder.newBuilder().build();
    }


    @Test
    public void test(){
        Long time = 1559726161000L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date(time)));
    }
}
