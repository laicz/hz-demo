package com.hz.hzdemo.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Create by zhoumingbing on 2019-08-20
 *
 * @author haizhi
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者：" + event.getValue());
    }
}
