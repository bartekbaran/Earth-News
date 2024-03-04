package com.earth.news.EarthNews.news.api;

import com.earth.news.EarthNews.articles.ArticlesService;
import com.earth.news.EarthNews.mapper.ArticleMapper;
import com.earth.news.EarthNews.models.response.ArticleDTO;
import com.earth.news.EarthNews.models.response.NewsApiResponseDTO;
import com.earth.news.EarthNews.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NewsApiRestClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsApiRestClient.class);
    
    @Value("${news.api.key}")
    private String newsApiKey;
    
    @Qualifier("newsApiWebClient")
    private final WebClient webClient;
    
    private static final String TOP_HEADLINES_ENDPOINT = "/v2/top-headlines";
    private static final String CATEGORY = "category";
    private static final String GENERAL = "general";
    
    private final ArticlesService articlesService;

    public NewsApiRestClient(final WebClient webClient, final ArticlesService articlesService) {
        this.webClient = webClient;
        this.articlesService = articlesService;
    }
    
    public Mono<NewsApiResponseDTO> getTopHeadlines() {
        final Mono<NewsApiResponseDTO> response = this.webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path(TOP_HEADLINES_ENDPOINT)
                .queryParam(CATEGORY, GENERAL)
                .build())
            .header("X-Api-Key", this.newsApiKey)
            .retrieve()
            .bodyToMono(NewsApiResponseDTO.class);
        
        response.map(newsApiResponseDTO ->
            this.articlesService.saveArticles(newsApiResponseDTO.articles().stream())
        ).doOnError(e -> LOGGER.error("Saving articles failed", e)).subscribe();
//        response.flatMap(newsApiResponseDTO -> this.articleRepository.saveAll(newsApiResponseDTO.articles().stream()
//                .map(articleDTO -> ArticleMapper.INSTANCE.map(articleDTO))
//                .toList()
//        )).subscribe();
        
        return response;
    }
    
}
