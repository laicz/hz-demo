package com.hz.hzdemo.kafka;

import com.hz.hzdemo.HzDemoApplication;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-08-08
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class KafkaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private KafkaAdmin kafkaAdmin;

    @Autowired
    private AdminClient adminClient;


    @Test
    public void sendDataAndCreateTopic() throws InterruptedException {
        String topic = "kafka.test.send_data_create_topic";
        ListenableFuture this_si_value = kafkaTemplate.send(topic, "this si value");
        Thread.sleep(1000000L);
    }

    @Test
    public void createTopicAndSendData() throws InterruptedException {
        String topic = "kafka.test.send_data_create_topic2";
        List<NewTopic> newTopics = new ArrayList<>();
        newTopics.add(new NewTopic(topic, 4, (short) 1));
        CreateTopicsResult result = adminClient.createTopics(newTopics);
        Map<String, KafkaFuture<Void>> values = result.values();
        long st = System.currentTimeMillis();
        values.forEach((key, value) -> {
            try {
                System.out.println(key + value.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("共耗时：" + (System.currentTimeMillis() - st));
        ListenableFuture this_is_value = kafkaTemplate.send(topic, "this is value");
        Thread.sleep(100000000L);
    }
}
