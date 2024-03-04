package com.earth.news.EarthNews.articles;

import com.earth.news.EarthNews.entity.ArticleEntity;
import com.earth.news.EarthNews.mapper.ArticleMapper;
import com.earth.news.EarthNews.models.response.ArticleDTO;
import com.earth.news.EarthNews.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ArticlesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticlesService.class);
	
	private final ArticleRepository articleRepository;
	
	public ArticlesService(final ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public List<ArticleDTO> getTodaysArticles() {
		final List<ArticleEntity> articleEntities = this.articleRepository.findAll();
		return articleEntities.stream()
			.map(articleEntity -> ArticleMapper.INSTANCE.map(articleEntity))
			.toList();
	}
	
	public List<ArticleEntity> saveArticles(final Stream<ArticleDTO> articleList) {
		return this.articleRepository.saveAll(articleList.map(ArticleMapper.INSTANCE::map).toList());
	}
}