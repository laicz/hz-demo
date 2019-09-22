package com.hz.hzdemo.kill_if_else;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 引入一个第三方的类来消除if else
 * Create by zhoumingbing on 2019-08-23
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO orderDTO) {
        return null;
    }
}
