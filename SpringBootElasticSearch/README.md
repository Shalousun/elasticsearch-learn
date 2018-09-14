Sprint Boot 2和ElasticSearch 5.x整合

# 环境要求
- ElasticSearch 5.0 +


ElasticSearch可以选择单点安装，安装后需要在elasticsearch.yml配置中开启 cluster.name配置。

# Spring Boot 2整合ElasticSearch 5.x的方式
Spring Boot 1.x版本是无法使用spring-boot-starter-data-elasticsearch来支持ElasticSearch 5.0.x以上版本的，当然如果非要使用Spring Boot 1.x版本，则可以直接使用通过自己集成ElasticSearch的相关依赖来解决。Spring Boot 2.x的版本整合ElasticSearch 5.x的版本非常简单。但是本demo中也尝试了另外的方案，这里将介绍两种整合方式。

## Spring Boot 2原生整合(推荐)
依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
```
配置elasticsearch,配置在application.properties或者是application.yml中

```
# elasticsearch的集群名称
spring.data.elasticsearch.cluster-name=my-application
# 格式 ip:端口 多个节点逗号隔开
spring.data.elasticsearch.cluster-nodes=192.168.237.129:9300
```
完成上面两个配置就ok了，配置非常的简单。

## 自定义ElasticSearch配置整合
就和自己编写一个配置类配配置ElasticSearch。操作如下。

```
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sunyu.elastic.repository")
public class EsConfig {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    /**
     * for elasticsearch 5.x
     * @return
     * @throws Exception
     */
    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", EsClusterName)
                .build();
        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        return new PreBuiltTransportClient(esSettings)
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
    }



   @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
    
}
```
配置elasticsearch,配置在application.properties或者是application.yml中

```
elasticsearch.clustername = my-application
elasticsearch.host = 192.168.237.129
elasticsearch.port = 9300
```

# 参考
https://www.mkyong.com/spring-boot/spring-boot-spring-data-elasticsearch-example/
官方demo地址：

https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-elasticsearch