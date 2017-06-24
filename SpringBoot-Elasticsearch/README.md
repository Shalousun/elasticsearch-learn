springboot和elasticsearch的整合，运行本例的时候需要配置ElasticSearch Cluster

配置：
 打开${ELASTICSEARCH_HOME}\config\elasticsearch.yml，添加下面内容。
 ```
 cluster.name: mkyong-cluster
 ```