package com.hz.hzdemo.base.juc.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create by zhoumingbing on 2019-06-04
 */
public class LinkedBlockingQueueTest {

    @Test
    public void testBlockingQueue() {
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(5);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        List<String> queue = new ArrayList<>();
        blockingQueue.drainTo(queue);
        queue.forEach(System.out::println);
    }
}
