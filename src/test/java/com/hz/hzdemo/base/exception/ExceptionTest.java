package com.hz.hzdemo.base.exception;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhoumingbing on 2019-06-18
 */
public class ExceptionTest {

    @Test
    public void tryException() {
        String result = "init";
        try {
            result = process();
        } catch (Exception e) {

        }
        System.out.println(result);
    }

    public String process() {
        int i = 1 / 0;
        return "process";
    }

    @Test
    public void testPage() {
        int pageNo = 2;
        int pageSize = 10;
        List<Integer> rows = new ArrayList<>();
        for (int i = 6; i < 16; i++) {
            rows.add(i + 1);
        }
        if (pageNo * pageSize > rows.size()) {
            rows = rows.subList(pageNo * pageSize - 16 - 1, pageSize);
        }
        for (Integer row : rows) {
            System.out.print(row + " : ");
        }
    }

    @Test
    public void testParseNullObject() {
        String s = JSON.toJSONString(null, true);
        System.out.println(s);
    }
}
