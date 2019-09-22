package com.hz.hzdemo.repository.es;

import com.hz.hzdemo.model.es.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Create by zhoumingbing on 2019-07-20
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
}
