package com.walgreens.nice.domain;

import java.util.Date;

public class Query {
	private String loggerServer;
	private String recordingStatus;
	private String playbackStatus;
	private Date lastRecordedTime;
	private String voiceArchiving;
	private String screenArchiving;
	private String overallStatus;
	
	
	public Query(String loggerServer, String recordingStatus,
			String playbackStatus, Date lastRecordedTime,
			String voiceArchiving, String screenArchiving, String overallStatus) {
		super();
		this.loggerServer = loggerServer;
		this.recordingStatus = recordingStatus;
		this.playbackStatus = playbackStatus;
		this.lastRecordedTime = lastRecordedTime;
		this.voiceArchiving = voiceArchiving;
		this.screenArchiving = screenArchiving;
		this.overallStatus = overallStatus;
	}
	public String getLoggerServer() {
		return loggerServer;
	}
	public void setLoggerServer(String loggerServer) {
		this.loggerServer = loggerServer;
	}
	public String getRecordingStatus() {
		return recordingStatus;
	}
	public void setRecordingStatus(String recordingStatus) {
		this.recordingStatus = recordingStatus;
	}
	public String getPlaybackStatus() {
		return playbackStatus;
	}
	public void setPlaybackStatus(String playbackStatus) {
		this.playbackStatus = playbackStatus;
	}
	public Date getLastRecordedTime() {
		return lastRecordedTime;
	}
	public void setLastRecordedTime(Date lastRecordedTime) {
		this.lastRecordedTime = lastRecordedTime;
	}
	public String getVoiceArchiving() {
		return voiceArchiving;
	}
	public void setVoiceArchiving(String voiceArchiving) {
		this.voiceArchiving = voiceArchiving;
	}
	public String getScreenArchiving() {
		return screenArchiving;
	}
	public void setScreenArchiving(String screenArchiving) {
		this.screenArchiving = screenArchiving;
	}
	public String getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}
}
