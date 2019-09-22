package com.hz.hzdemo.kill_if_else;

/**
 * 订单父类类型，定义基本方法
 * Create by zhoumingbing on 2019-08-23
 */
public interface OrderService {

    /**
     * 具体又不同类型的子类来具体执行
     * @param orderDTO
     * @return
     */
    String handle(OrderDTO orderDTO);
}
