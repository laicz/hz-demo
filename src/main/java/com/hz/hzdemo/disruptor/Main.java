package com.hz.hzdemo.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Disruptor是基于事件的
 * Create by zhoumingbing on 2019-08-20
 */
public class Main {

    public static void main(String[] args) {
        //1.实例化disruptor对象
        OrderEventFactory eventFactory = new OrderEventFactory();
        int ringBufferSize = 1024 * 1024;
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Disruptor<OrderEvent> disruptor = new Disruptor<>(eventFactory,
                ringBufferSize,
                executorService,
                ProducerType.SINGLE,
                new BlockingWaitStrategy());

        //2.添加消费者
        disruptor.handleEventsWith(new OrderEventHandler());

        //3.启动disruptor
        disruptor.start();

        //4.获取实际存储数据的容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        ByteBuffer allocate = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            allocate.putLong(0, i);
            producer.sendData(allocate);
        }


        //关闭
        disruptor.shutdown();
        executorService.shutdown();
    }
}
