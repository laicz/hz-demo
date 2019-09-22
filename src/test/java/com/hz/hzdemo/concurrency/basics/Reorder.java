package com.hz.hzdemo.concurrency.basics;

/**
 * 重排序
 * - 在并发情况下导致结果不一致问题
 * <p>
 * Create by zhoumingbing on 2019-08-19
 */
public class Reorder {

    int a = 0;
    boolean flag = false;

    public void write() {
        int a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            System.out.println(a);
        }
    }

}
