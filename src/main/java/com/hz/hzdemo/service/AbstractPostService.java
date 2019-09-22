package com.hz.hzdemo.service;

import org.springframework.stereotype.Component;

/**
 * Create by zhoumingbing on 2019-06-18
 */
@Component
public abstract class AbstractPostService {

    protected String signKey;

    protected abstract void setSignKey();

    public String getSignKey() {
        return this.signKey;
    }

}
