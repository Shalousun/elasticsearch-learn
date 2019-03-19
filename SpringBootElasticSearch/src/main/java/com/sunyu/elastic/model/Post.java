package com.sunyu.elastic.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author yu 2019/3/19.
 */
@Data
@ToString
@Document(indexName = "projectname", type = "post", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private int userId;

    private int weight;
}
