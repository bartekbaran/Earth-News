package com.earth.news.EarthNews.models.response;

public record ArticleDTO(
	String title,
	String author,
	String description,
	String url,
	String urlToImage,
	String publishedAt
) {}
