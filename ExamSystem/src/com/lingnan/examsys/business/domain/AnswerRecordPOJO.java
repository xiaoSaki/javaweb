package com.lingnan.examsys.business.domain;

import java.sql.Timestamp;

public class AnswerRecordPOJO {
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getError_sum() {
		return error_sum;
	}
	public void setError_sum(int error_sum) {
		this.error_sum = error_sum;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public Timestamp getAns_begin() {
		return ans_begin;
	}
	public void setAns_begin(Timestamp ans_begin) {
		this.ans_begin = ans_begin;
	}
	public Timestamp getAns_end() {
		return ans_end;
	}
	public void setAns_end(Timestamp ans_end) {
		this.ans_end = ans_end;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	private int ans_id;
	private int exam_id;
	private int error_sum;
	private int teacher_id;
	private String exam_name;
	private String teacher_name;
	private Timestamp ans_begin;
	private Timestamp ans_end;
}
