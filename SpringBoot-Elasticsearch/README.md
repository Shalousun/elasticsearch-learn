springboot和elasticsearch的整合，运行本例的时候需要配置ElasticSearch Cluster

配置：
 打开${ELASTICSEARCH_HOME}\config\elasticsearch.yml，添加下面内容。
 ```
 cluster.name: mkyong-cluster
 ```
在maven依赖时如果指定elasticsearch版本elasticsearch.version，将会导致springbbot中的elasticsearch的版本失效
```
<elasticsearch.version>5.4.0</elasticsearch.version>
```
官方demo地址：

https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-elasticsearch