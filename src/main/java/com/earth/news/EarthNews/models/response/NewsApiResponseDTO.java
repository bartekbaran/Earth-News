package com.earth.news.EarthNews.models.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public record NewsApiResponseDTO(
	String status,
	Integer totalResults,
	List<ArticleDTO> articles
) {}

//public class NewsApiResponseDTO {
//	
//	private String status;
//	private Integer totalResults;
//	private List<ArticleDTO> articles;
//	
//	public NewsApiResponseDTO() {
//	}
//
//	public NewsApiResponseDTO(final String status, final Integer totalResults, final List<ArticleDTO> articles) {
//	    this.status = status;
//	    this.totalResults = totalResults;
//	    this.articles = articles;
//	}
//	
//	public String getStatus() {
//	    return this.status;
//	}
//
//	public Integer getTotalResults() {
//	    return this.totalResults;
//	}
//
//	public List<ArticleDTO> getArticles() {
//	    return this.articles;
//	}
//	
//	@Override
//    public boolean equals(Object that) {
//		return EqualsBuilder.reflectionEquals(this, that);
//	}
//
//	@Override
//    public int hashCode() {
//		return HashCodeBuilder.reflectionHashCode(this);
//	}
//		
//	@Override
//	public String toString() {
//	    return "NewsApiResponseDTO{" +
//	        "status ='" + this.status + '\'' +
//	        ", totalResults = " + this.totalResults +
//	        ", articles = " + this.articles +
//	        '}';
//	}
//}
