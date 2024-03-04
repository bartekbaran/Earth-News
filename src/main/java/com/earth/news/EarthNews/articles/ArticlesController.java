package com.earth.news.EarthNews.articles;

import com.earth.news.EarthNews.models.response.ArticleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticlesController.class);

	private final ArticlesService articlesService;

	public ArticlesController(final ArticlesService articlesService) {
		this.articlesService = articlesService;
	}
	
	@GetMapping
	public List<ArticleDTO> getTodaysArticles() {
		LOGGER.info("Getting todays articles");
		return this.articlesService.getTodaysArticles();
	}
}