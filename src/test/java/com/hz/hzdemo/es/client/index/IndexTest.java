package com.hz.hzdemo.es.client.index;

import com.hz.hzdemo.HzDemoApplication;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;

/**
 * Create by zhoumingbing on 2019-07-21
 */
@ContextConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class IndexTest {

    private final String INDEX = "stores";
    private final String TYPE = "book";


    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 存储数据
     * @throws IOException
     */
    @Test
    public void saveData() throws IOException {
        IndexRequest request = new IndexRequest(INDEX, TYPE);
        request.id("2321");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response);
        GetRequest getRequest = new GetRequest();
        getRequest.index(INDEX);
        getRequest.type(TYPE);
        getRequest.id("2321");
        GetResponse getResponse = restHighLevelClient.get(getRequest);
        System.out.println(getResponse.getSource());
    }

    /**
     * 存储通过XContentBuilder创建的数据
     * @throws IOException
     */
    @Test
    public void saveDataByXContentBuilder() throws IOException {
        IndexRequest indexRequest = new IndexRequest();
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .field("user", "zhou")
                .field("wife", "zhuang")
                .timeField("marryTime", new Date())
                .endObject();
        indexRequest.index(INDEX).type(TYPE);
        indexRequest.source(xContentBuilder);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
    }

    /**
     * 其他的一些扩展参数
     */
    @Test
    public void optionArgument(){
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.routing();     //指定路由信息
        indexRequest.timeout(new TimeValue(100L));  //指定超时时间，默认单位为毫秒
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE); //指定不刷新  默认值
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE); //刷新   在index的时候会创建一个刷新线程，在测试的时候有用
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);//刷新，知道结果返回
        indexRequest.opType(DocWriteRequest.OpType.CREATE);//操作类型
    }


    /**
     * 异步执行
     */
    @Test
    public void syncExecution(){
        restHighLevelClient.indexAsync(new IndexRequest(), RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {

            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("*********************************************");
            }
        });
    }

    /**
     * 版本冲突异常
     */
    public void versionConflict(){
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.version();
        try {
            IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
