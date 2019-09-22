package com.hz.hzdemo.web;

import com.alibaba.fastjson.JSON;
import com.hz.hzdemo.service.ZhouPostService;
import com.hz.hzdemo.service.ZhuangPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-06-18
 */
@RestController
public class PostConstructController {

    @Autowired
    private ZhuangPostService zhuangPostService;

    @Autowired
    private ZhouPostService zhouPostService;

    @GetMapping(value = "/getPostConstruct")
    public String getPostConstruct() {
        Map<String, String> result = new HashMap<>();
        result.put("zhuangPostService", zhuangPostService.getSignKey());
        result.put("zhouPostService", zhouPostService.getSignKey());
        return JSON.toJSONString(result);
    }
}
