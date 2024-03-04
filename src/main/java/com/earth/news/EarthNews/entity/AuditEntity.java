package com.earth.news.EarthNews.entity;

import jakarta.persistence.Column;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class AuditEntity {
	
	@Column(updatable = false, nullable = false)
    private LocalDateTime createDate;
	@Column
    private LocalDateTime updateDate;
	@Column
    private LocalDateTime removeDate;
	
	public final LocalDateTime getCreateDate() {
	    return this.createDate;
	}

	public void setCreateDate(final LocalDateTime createDate) {
	    this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
	    return this.updateDate;
	}

	public void setUpdateDate(final LocalDateTime updateDate) {
	    this.updateDate = updateDate;
	}

	public LocalDateTime getRemoveDate() {
	    return this.removeDate;
	}

	public void setRemoveDate(final LocalDateTime removeDate) {
	    this.removeDate = removeDate;
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
	    return "AuditEntity{" +
	            "createDate=" + this.createDate +
	            ", updateDate=" + this.updateDate +
	            ", removeDate=" + this.removeDate +
	            '}';
	}
}
