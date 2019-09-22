package com.hz.hzdemo.es.client.index;

import com.hz.hzdemo.HzDemoApplication;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Create by zhoumingbing on 2019-07-23
 */
@ContextConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class GetTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 同步执行
     *
     * @throws IOException
     */
    @Test
    public void getDocumentById() throws IOException {
        String index = "my_index";
        String type = "my_type";
        GetRequest getRequest = new GetRequest(index, type, "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse);
    }

    /**
     * 异步执行
     *
     * @throws InterruptedException
     */
    @Test
    public void getAsync() throws InterruptedException {
        String index = "my_index";
        String type = "my_type";
        GetRequest getRequest = new GetRequest(index, type, "1");
        restHighLevelClient.getAsync(getRequest, RequestOptions.DEFAULT, new ActionListener<GetResponse>() {
            @Override
            public void onResponse(GetResponse documentFields) {
                System.out.println(documentFields);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000L);

    }
}
