package com.hz.hzdemo.es.client;

import com.alibaba.fastjson.JSON;
import com.hz.hzdemo.HzDemoApplication;
import com.hz.hzdemo.model.es.Article;
import com.hz.hzdemo.repository.es.ArticleRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Create by zhoumingbing on 2019-07-20
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class EsTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TransportClient transportClient;

    @Test
    public void initElasticsearchClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "zmb-application")
                .put("client.transport.sniff", false)
                .put("thread_pool.search.size", 6).build();

        TransportClient transportClient = new PreBuiltTransportClient(settings);
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("60.205.176.135"), 9300);
        TransportAddress transportAddress1 = new TransportAddress(InetAddress.getByName("60.205.176.135"), 9310);
        TransportAddress transportAddress2 = new TransportAddress(InetAddress.getByName("60.205.176.135"), 9320);
        transportClient.addTransportAddress(transportAddress)
                .addTransportAddress(transportAddress1)
                .addTransportAddress(transportAddress2);
        SearchResponse searchResponse = transportClient.prepareSearch("cars").execute().actionGet();
        System.out.println(searchResponse);
    }

    @Test
    public void save() {
        Article article = new Article();
        article.setAuthor("Alice");
        article.setContent("spring boot data es");
        article.setId(1l);
        article.setPv(100);
        article.setSummary("spring boot es");
        articleRepository.save(article);
    }

    @Test
    public void transportClientInfo() {
        Settings settings = transportClient.settings();
        System.out.println(settings.toString());
        System.out.println("---------------------------");
        List<TransportAddress> transportAddresses = transportClient.transportAddresses();
        transportAddresses.stream().forEach(transportAddress -> {
            System.out.println("host=[" + transportAddress.getAddress() + "] : port=[" + transportAddress.getPort() + "]");
        });
    }
}
