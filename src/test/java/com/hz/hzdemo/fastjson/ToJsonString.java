package com.hz.hzdemo.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Create by zhoumingbing on 2019-09-16
 */
public class ToJsonString {

    private static final String sql = "{\n" +
            "    \"source\": {\n" +
            "      \"hiveSQL\": \"select * from etl_kgp_loader.etl_company limit 1000\"\n" +
            "    },\n" +
            "    \"sink\": {\n" +
            "      \"storeType\": \"hbase\",\n" +
            "      \"es\": {\n" +
            "        \"url\": \"192.168.1.49:9200,192.168.1.51:9200\",\n" +
            "        \"index\": \"etl_kgp_loader.etl_company\",\n" +
            "        \"type\": \"etl_company\",\n" +
            "        \"setting\": {\"index.number_of_shards\":5,\"index.number_of_replicas\":1,\"analysis\":{\"analyzer\":{\"ik\":{\"type\":\"custom\",\"tokenizer\":\"ik_max_word\"}}},\"index\":{\"blocks\":{\"read_only_allow_delete\":false}}},\n" +
            "        \"mapping\": {\"_all\":{\"enabled\":false},\"date_detection\":false,\"dynamic_templates\":[{\"strings\":{\"match_mapping_type\":\"string\",\"mapping\":{\"type\":\"text\",\"analyzer\":\"ik\",\"fields\":{\"keyword\":{\"type\":\"keyword\"}}}}}]}\n" +
            "      },\n" +
            "      \"hbase\": {\n" +
            "        \"url\": \"192.168.1.131,192.168.1.132,192.168.1.134:2181\",\n" +
            "        \"namespace\": \"etl_kgp_loader\",\n" +
            "        \"table\": \"etl_company\",\n" +
            "        \"logicPartitions\": 1000,\n" +
            "        \"physicsPartitions\": 16\n" +
            "      }\n" +
            "    },\n" +
            "    \"gapConfig\": {\n" +
            "      \"schema\": {\n" +
            "        \"id\": 1,\n" +
            "        \"graphId\": 2,\n" +
            "        \"name\": \"etl_company\",\n" +
            "        \"type\": \"vertex\",\n" +
            "        \"useGdb\": \"vertex\",\n" +
            "        \"useSearch\": \"vertex\",\n" +
            "        \"fields\": {\n" +
            "          \"object_key\":{\n" +
            "            \"id\": 1,\n" +
            "            \"name\": \"object_key\",\n" +
            "            \"type\": \"STRING\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"string_field\":{\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"string_field\",\n" +
            "            \"type\": \"STRING\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"long_field\":{\n" +
            "            \"id\": 2,\n" +
            "            \"name\": \"long_field\",\n" +
            "            \"type\": \"LONG\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"double_field\":{\n" +
            "            \"id\": 3,\n" +
            "            \"name\": \"double_field\",\n" +
            "            \"type\": \"DOUBLE\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"string_double_field\":{\n" +
            "            \"id\": 3,\n" +
            "            \"name\": \"string_double_field\",\n" +
            "            \"type\": \"DOUBLE\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"array_field\":{\n" +
            "            \"id\": 4,\n" +
            "            \"name\": \"a\",\n" +
            "            \"type\": \"ARRAY\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          },\n" +
            "          \"date_field\":{\n" +
            "            \"id\": 4,\n" +
            "            \"name\": \"a\",\n" +
            "            \"type\": \"DATETIME\",\n" +
            "            \"isMain\": \"N\",\n" +
            "            \"required\": \"Y\"\n" +
            "          }\n" +
            "        }\n" +
            "      },\n" +
            "      \"errorStoreEnabled\": true,\n" +
            "      \"errorStoreRowsLimit\": 30000,\n" +
            "      \"errorMode\": -1\n" +
            "    },\n" +
            "    \"sparkConfig\": {\n" +
            "      \"numPartitions\": 100\n" +
            "    }\n" +
            "  }";

    public static void main(String[] args) {
        String s = JSON.toJSONString(JSON.parseObject(sql));
        System.out.println(s);
    }
}
