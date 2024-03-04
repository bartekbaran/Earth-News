package com.earth.news.EarthNews.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NewsApiWebClientConfig {
    
    @Value("${news.api.base.url}")
    private String newsApiBaseUrl;
    
    @Bean("newsApiWebClient")
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl(newsApiBaseUrl)
            .build();
    }
}