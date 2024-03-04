package com.earth.news.EarthNews.news.api;

import com.earth.news.EarthNews.models.response.NewsApiResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/newsApi")
public class NewsApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewsApiController.class);

	private final NewsApiRestClient newsApiRestClient;

	public NewsApiController(final NewsApiRestClient newsApiRestClient) {
		this.newsApiRestClient = newsApiRestClient;
	}

	@GetMapping("/headlines")
	public Mono<NewsApiResponseDTO> getTopHeadlines() {
		return this.newsApiRestClient.getTopHeadlines();
	}
}