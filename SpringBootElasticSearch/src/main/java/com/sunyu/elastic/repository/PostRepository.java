package com.sunyu.elastic.repository;

import com.sunyu.elastic.model.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yu 2019/3/19.
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {


}
