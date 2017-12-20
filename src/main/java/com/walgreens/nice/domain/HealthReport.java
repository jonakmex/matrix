package com.walgreens.nice.domain;

import java.util.List;

public class HealthReport {
	
	private String fileName;
	private int status; // 0-Started, 1-Completed
	
	private ReportHeader reportHeader;
	private List<NiceApp> niceApps;
	private List<Query> queries;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ReportHeader getReportHeader() {
		return reportHeader;
	}
	public void setReportHeader(ReportHeader reportHeader) {
		this.reportHeader = reportHeader;
	}
	public List<NiceApp> getNiceApps() {
		return niceApps;
	}
	public void setNiceApps(List<NiceApp> niceApps) {
		this.niceApps = niceApps;
	}
	public List<Query> getQueries() {
		return queries;
	}
	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}
}
