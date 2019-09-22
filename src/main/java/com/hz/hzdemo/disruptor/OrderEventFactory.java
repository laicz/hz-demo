package com.hz.hzdemo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂
 * Create by zhoumingbing on 2019-08-20
 *
 * @author haizhi
 */

public class OrderEventFactory implements EventFactory<OrderEvent> {

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }

}
