package com.hz.hzdemo.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Create by zhoumingbing on 2019-06-18
 */
@Service(value = "zhouPostService")
public class ZhouPostService extends AbstractPostService {
    @Override
    @PostConstruct
    protected void setSignKey() {
        signKey = "zhou";
    }
}
