package com.walgreens.nice.domain;

import java.util.Date;

public class ReportHeader {
	private String preparedBy;
	private String reviewedBy;
	private Date generationDate;
	private Date generationTime;
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public Date getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}
	public Date getGenerationTime() {
		return generationTime;
	}
	public void setGenerationTime(Date generationTime) {
		this.generationTime = generationTime;
	}
}	
