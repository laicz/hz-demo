package com.hz.hzdemo.base.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-05-28
 */
public class StringTest {

    public static final String SELECT = "select";
    public static final String FROM = "from";
    public static final String WHERE = "where";
    public static final String ExitCode = "exitCode";
    public static final String OutputFile = "outputFile";

    @Test
    public void sql() {
        String sql = "select a,b from table_name";
        Map<String, Object> params = new HashMap<>();
        extractParamFromSql(sql, params);
        System.out.println(params);
    }

    private void extractParamFromSql(String sql, Map<String, Object> params) {
        int selectPos = StringUtils.indexOfIgnoreCase(sql, SELECT);
        int fromPos = StringUtils.indexOfIgnoreCase(sql, FROM);
        int wherePos = StringUtils.indexOfIgnoreCase(sql, WHERE);

        if (selectPos == -1 || fromPos == -1) {
            throw new RuntimeException("sql [" + sql + "] illegal");
        }
        String fields = sql.substring(selectPos + SELECT.length(), fromPos);
        String table = wherePos > -1 ? sql.substring(fromPos + FROM.length(), wherePos) : sql.substring(fromPos + FROM.length());
        String filter = wherePos > -1 ? sql.substring(wherePos + WHERE.length()) : "";

        System.out.println("fields :" + fields.trim());
        System.out.println("table :" + table.trim());
        System.out.println("filter :" + filter.trim());
        params.put("table", table.trim());
        params.put("fields", fields.trim());
        if (StringUtils.isNotBlank(filter.trim())) {
            params.put("filter", filter.trim());
        }
    }

    @Test
    public void subString() {
        List<String> srcList = new ArrayList<>();
        srcList.add("1");
        srcList.add("2");
        srcList.add("3");
        srcList.add("4");
        List<String> strings = srcList.subList(0, 2);
        srcList.stream().forEach(str -> System.out.println(str));
        System.out.println("-------------------");
        strings.stream().forEach(str -> System.out.println(str));
    }

    @Test
    public void testHashCode(){
        String str = "42332";
        System.out.println(str.hashCode());
        char val[] = str.toCharArray();

        int h = 0;
        for (int i = 0; i < val.length; i++) {
            h = 32 * h + val[i];
        }
        System.out.println(h);
    }
}
