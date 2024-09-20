package com.serkomma.opensearch;

import org.apache.http.HttpHost;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.data.client.orhlc.AbstractOpenSearchConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@ComponentScan(basePackages = "com.serkomma.opensearch")
@EnableElasticsearchRepositories(basePackages
        = "com.serkomma.opensearch.repositories")
public class OpensearchConfiguration extends AbstractOpenSearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient opensearchClient() {

        RestClientBuilder builder = RestClient.builder(
                        new HttpHost("localhost", 9200))
                .setRequestConfigCallback(
                        requestConfigBuilder -> requestConfigBuilder
                                .setConnectionRequestTimeout(0));

        return new RestHighLevelClient(builder);
    }
}