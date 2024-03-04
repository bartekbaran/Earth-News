package com.earth.news.EarthNews.mapper;

import com.earth.news.EarthNews.entity.ArticleEntity;
import com.earth.news.EarthNews.models.response.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {
	
	ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
	
	ArticleDTO map(ArticleEntity articleEntity);
	
	ArticleEntity map(ArticleDTO articleDTO);
}