package com.lingnan.examsys.business.domain;

import java.util.Date;

public class AnnouncementVO {
	private int Announcement_id;
	private String text;
	private String user_name;
	private Date Announcement_time;
	public int getAnnouncement_id() {
		return Announcement_id;
	}
	public void setAnnouncement_id(int announcement_id) {
		Announcement_id = announcement_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getAnnouncement_time() {
		return Announcement_time;
	}
	public void setAnnouncement_time(Date announcement_time) {
		Announcement_time = announcement_time;
	}
}
