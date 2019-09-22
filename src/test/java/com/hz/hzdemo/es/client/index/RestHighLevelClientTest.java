package com.hz.hzdemo.es.client.index;

import com.hz.hzdemo.HzDemoApplication;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Create by zhoumingbing on 2019-07-22
 */
@ContextConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void restHighLevelClientInfo() throws IOException {
        System.out.println(restHighLevelClient);
    }
}
