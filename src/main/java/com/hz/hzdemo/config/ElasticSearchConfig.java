package com.hz.hzdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by zhoumingbing on 2019-05-09
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch.high.level")
public class ElasticSearchConfig {
    private static final String COLON = ":";
    private static final String COMMA = ",";

    @Value(value = "${elasticsearch.high.level.nodes}")
    private String nodes;

    @Bean
    public RestClientBuilder restClientBuilder() {
        String clusterNodes = nodes;
        HttpHost[] httpHost = buildHttpHosts(clusterNodes);
        return RestClient.builder(httpHost);
    }

    @Bean(value = "highLevelClient")
    public RestHighLevelClient highLevelClient(RestClientBuilder restClientBuilder) {
        restClientBuilder.setMaxRetryTimeoutMillis(60000);
        return new RestHighLevelClient(restClientBuilder);
    }

    private HttpHost[] buildHttpHosts(String clusterNodes) {
        Assert.hasText(clusterNodes, "Cluster nodes source must not be null or empty!");

        String[] nodes = StringUtils.delimitedListToStringArray(clusterNodes, COMMA);

        List<HttpHost> httpHostList = Arrays.stream(nodes).map(node -> {

            String[] segments = StringUtils.delimitedListToStringArray(node, COLON);

            Assert.isTrue(segments.length == 2,
                    () -> String.format("Invalid cluster node %s in %s! Must be in the format host:port!", node, clusterNodes));

            String host = segments[0].trim();
            String port = segments[1].trim();

            Assert.hasText(host, () -> String.format("No host name given cluster node %s!", node));
            Assert.hasText(port, () -> String.format("No port given in cluster node %s!", node));

            return new HttpHost(host, Integer.parseInt(port));
        }).collect(Collectors.toList());
        return httpHostList.toArray(new HttpHost[httpHostList.size()]);
    }
}
