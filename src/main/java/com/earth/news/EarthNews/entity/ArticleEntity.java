package com.earth.news.EarthNews.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

@Entity
@Table(name = "articles")
public class ArticleEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String title;
    private String author;
    private String description;
    private String url;
    @Column(columnDefinition = "text")
    private String urlToImage;
    private String publishedAt;
	
	public ArticleEntity() {
	}
    
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public void setUrlToImage(final String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(final String publishedAt) {
        this.publishedAt = publishedAt;
    }
    
    @Override
	public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
	public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", description='" + this.description + '\'' +
                ", url='" + this.url + '\'' +
                ", urlToImage='" + this.urlToImage + '\'' +
                ", publishedAt='" + this.publishedAt + '\'' +
                '}';
    }
}