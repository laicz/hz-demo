package com.hz.hzdemo.base.generacity;

/**
 * Create by zhoumingbing on 2019-05-16
 */
public class StringGenerator implements Generator<String> {

    @Override
    public String next(String param) {
        System.out.println("StringGenerator: " + param);
        return "this is next";
    }

    private void owner() {

    }

}
