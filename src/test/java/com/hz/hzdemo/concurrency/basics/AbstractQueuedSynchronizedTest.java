package com.hz.hzdemo.concurrency.basics;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by zhoumingbing on 2019-08-23
 */
public class AbstractQueuedSynchronizedTest {

    @Test
    public void showNode() {
        final ReentrantLock lock = new ReentrantLock();
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        lock.lock();
        lock.unlock();
    }
}
