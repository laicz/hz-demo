package com.hz.hzdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author zhoumb
 */
@SpringBootApplication
@EnableCaching
public class HzDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzDemoApplication.class, args);
    }

}
