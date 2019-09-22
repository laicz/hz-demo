package com.hz.hzdemo.concurrency.basics;

import org.junit.Test;

/**
 * 线程名称最好需要命名，这样知道是自己的线程出现问题
 * Create by zhoumingbing on 2019-09-11
 */
public class ThreadLifeStatusTest {

    @Test
    public void running() throws InterruptedException {
        new Thread(() -> {
            while (true){

            }
        },"thread_runnable").start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
