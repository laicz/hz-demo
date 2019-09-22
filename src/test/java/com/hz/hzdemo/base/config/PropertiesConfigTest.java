package com.hz.hzdemo.base.config;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Create by zhoumingbing on 2019-08-29
 */
public class PropertiesConfigTest {

    @Test
    public void loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(PropertiesConfigTest.class.getClassLoader().getResourceAsStream("hello.properties"));
        System.out.println(properties);
    }
}
