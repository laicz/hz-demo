package com.hz.hzdemo.disruptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单事件
 * Create by zhoumingbing on 2019-08-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private long value;

}
