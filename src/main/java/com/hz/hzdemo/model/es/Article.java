package com.hz.hzdemo.model.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * pojo类上添加@Document注解，同时指明index和type名称
 * Create by zhoumingbing on 2019-07-20
 */
@Data
@Document(indexName = "blog", type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 3626187267772680704L;

    private Long id;

    private String title;

    private String content;

    private String summary;

    private int pv;

    private String author;
}
