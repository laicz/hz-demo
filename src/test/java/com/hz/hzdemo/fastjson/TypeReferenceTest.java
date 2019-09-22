package com.hz.hzdemo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-08-12
 */
public class TypeReferenceTest {

    @Test
    public void typeReference(){
        String str = "";
        Map<String, List<String>> stringListMap = JSON.parseObject(str, new TypeReference<Map<String, List<String>>>(){});
    }
}
