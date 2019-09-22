package com.hz.hzdemo.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Create by zhoumingbing on 2019-08-21
 *
 * @author haizhi
 */
public class OrderEventProducer {

    private RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(ByteBuffer allocate) {
        //1、在生产者发送消息的时候，需要我们从ringBuffer里面获取一个可用的序号
        long sequence = ringBuffer.next();
        try {
            //2、根据这个序号，找到具体的元素
            OrderEvent orderEvent = ringBuffer.get(sequence);
            //3、进行实际的赋值
            orderEvent.setValue(allocate.getLong(0));
        } finally {
            //4、提交操作
            ringBuffer.publish(sequence);
        }
    }
}
