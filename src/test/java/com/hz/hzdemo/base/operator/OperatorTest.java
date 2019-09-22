package com.hz.hzdemo.base.operator;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2019-05-24
 */
public class OperatorTest {

    @Test
    public void intValue(){
        Integer value = 0 ;
        int i = value & 1;
        System.out.println(value & 1);
        if ((value & 1) == 1){

        }
    }
}
