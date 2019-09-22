package com.hz.hzdemo.es.client;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-05-09
 */
//@ContextConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = HzDemoApplication.class)
public class ClientTest {

    private static final String index = "haizhi_test";
    private static final String type = "haizhi_type";

    private TransportClient transportClient;

//    @Autowired
//    private TransportClient transportClient;

    @Before
    public void init() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "zmb-application")
                .put("client.transport.sniff", false)
                .put("thread_pool.search.size", 6).build();

        transportClient = new PreBuiltTransportClient(settings);
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("60.205.176.135"), 9300);
        transportClient.addTransportAddress(transportAddress);

    }

//    @Test
//    public void showClientInfo(){
//        List<DiscoveryNode> discoveryNodes = transportClient.connectedNodes();
//        for (DiscoveryNode discoveryNode : discoveryNodes) {
//            System.out.println(discoveryNode.getAddress());
//            System.out.println(discoveryNode.getHostAddress());
//            System.out.println(discoveryNode.getId());
//            System.out.println(discoveryNode.getVersion());
//        }
//
//    }

    /**
     * 需要先获取到数据的管理员权限
     * 判断索引是否存在
     */
    @Test
    public void isIndexExist() {
        IndicesExistsResponse indicesExistsResponse = transportClient.admin().indices().exists(new IndicesExistsRequest("javaapi")).actionGet();
        boolean exists = indicesExistsResponse.isExists();
        System.out.println(exists);

    }

    /**
     * 创建一个索引
     */
    @Test
    public void createIndex() {
        CreateIndexResponse createIndexResponse = transportClient
                .admin().indices().prepareCreate("javaapi").execute().actionGet();
        System.out.println(createIndexResponse);
    }

    /**
     * 索引数据
     */
    @Test
    public void addJSONStringData() throws ExecutionException, InterruptedException {
        Map<String, Object> data = new HashMap<>();
        data.put("type", "java api");
        data.put("dataType", "String");
        data.put("createTime", new Date());
        data.put("creatBy", "zmb");
        data.put("size", 5);
        data.put("id", 999);


        createIndexIfNotExists();

        IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex(index, type)
                //设置数据实体
                .setSource(JSON.toJSONString(data), XContentType.JSON);
        IndexResponse indexResponse = indexRequestBuilder.get();
        printResponse(indexResponse);
    }

    /**
     * source中的id只是一个普通属性
     * setId才是数据的主键
     */
    @Test
    public void addMapString() {
        Map<String, Object> source = new HashMap<>();
        source.put("type", "java api");
        source.put("data type", "map");
        source.put("createBy", "zzz");
        IndexResponse indexResponse = transportClient.prepareIndex(index, type)
                .setSource(source).setId("this is set source id ").get();
        printResponse(indexResponse);
    }

    @Test
    public void addObject() throws IOException {
        IndexResponse indexResponse = transportClient.prepareIndex(index, type).setSource(XContentFactory.jsonBuilder().startObject()
                .field("id", "0000000")
                .field("createBy", "zzm")
                .field("createDt", new Date())
                .endObject()).get();
        printResponse(indexResponse);
    }

    @Test
    public void getObject() {
        String id = "e5B-tWoBkaAYOGhyJtm-";
        getObject(id);
    }

    private void getObject(String id) {
        GetResponse documentFields = transportClient.prepareGet(index, type, id).get();
        System.out.println(JSON.toJSONString(documentFields));
    }

    /**
     * 只能删除已经明确的ID
     */
    @Test
    public void deleteObject() {
        String id = "e5B-tWoBkaAYOGhyJtm-";
        DeleteResponse deleteResponse = transportClient.prepareDelete(index, type, id).get();
        System.out.println(JSON.toJSONString(deleteResponse));
        getObject();
    }

    @Test
    public void deleteByQueryFilter() {
        String id = "";
        getObject(id);
        //创建一个查询删除 （可以设置多个查询条件）
        new DeleteByQueryRequestBuilder(transportClient, DeleteByQueryAction.INSTANCE)
                .filter(QueryBuilders.matchQuery("","")) // query
                .source("") // index
                .execute(new ActionListener<BulkByScrollResponse>() {
                    @Override
                    public void onResponse(BulkByScrollResponse bulkByScrollResponse) {
                        // 执行成功  返回结果
                    }

                    @Override
                    public void onFailure(Exception e) {
                        // 执行失败  返回异常信息
                    }
                });
    }

    private void printResponse(IndexResponse indexResponse) {
        System.out.println(indexResponse.getIndex() + " : " + indexResponse.getType() + " : " + indexResponse.getId());
    }

    private void createIndexIfNotExists() throws InterruptedException, ExecutionException {
        if (!transportClient.admin().indices().exists(new IndicesExistsRequest(index)).get().isExists()) {
            transportClient.admin().indices().prepareCreate(index);
        }
    }
}
