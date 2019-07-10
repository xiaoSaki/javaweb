package com.lingnan.examsys.business.domain;

import java.sql.Timestamp;

public class ExaminationVO {
	private int exam_id;
	private int user_id;
	private String exam_name;
	private Timestamp exam_begin;
	private Timestamp exam_end;
	private int chapter;
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public Timestamp getExam_begin() {
		return exam_begin;
	}
	public void setExam_begin(Timestamp exam_begin) {
		this.exam_begin = exam_begin;
	}
	public Timestamp getExam_end() {
		return exam_end;
	}
	public void setExam_end(Timestamp exam_end) {
		this.exam_end = exam_end;
	}

}
