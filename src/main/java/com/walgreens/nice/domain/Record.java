package com.walgreens.nice.domain;

import java.util.Date;

public class Record {
	
	private String type;
	private String flag;
	private String fullName;
	private Date startTime;
	private Date stopTime;
	private Date duration;
	private String voiceStatus;
	private String screenStatus;
	private String userDepartment;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public String getVoiceStatus() {
		return voiceStatus;
	}
	public void setVoiceStatus(String voiceStatus) {
		this.voiceStatus = voiceStatus;
	}
	public String getScreenStatus() {
		return screenStatus;
	}
	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}
	public String getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
}
