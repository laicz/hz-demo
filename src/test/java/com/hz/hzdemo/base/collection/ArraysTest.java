package com.hz.hzdemo.base.collection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-05-07
 */
public class ArraysTest {

    @Test
    public void toArrayTest() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        String[] array = strings.toArray(new String[0]);
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(array);
    }

    @Test
    public void strToInteger() {
        System.out.println(new Date());

        BooleanTest test = new BooleanTest();
        if (test.getBoo() != null && test.getBoo()) {
            System.out.println("is true ");
        } else {
            System.out.println("is false ");
        }

        String user = (String) null;
        Map map = JSON.parseObject(user, Map.class);
        System.out.println(map);
    }

    private class BooleanTest {
        private Boolean boo;
        public Boolean getBoo() {
            return boo;
        }

        public void setBoo(Boolean boo) {
            this.boo = boo;
        }
    }
}
