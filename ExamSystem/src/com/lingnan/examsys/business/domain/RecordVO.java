package com.lingnan.examsys.business.domain;

import java.sql.Timestamp;

public class RecordVO {
	private int user_id;
	private int exam_id;
	private int que_id;
	private int error_flag;
	private Timestamp time;
	private int seq_num;
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getError_flag() {
		return error_flag;
	}
	public void setError_flag(int error_flag) {
		this.error_flag = error_flag;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "RecordVO [user_id=" + user_id + ", exam_id=" + exam_id + ", que_id=" + que_id + ", error_flag="
				+ error_flag + ", time=" + time + ", seq_num=" + seq_num + "]";
	}
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
}
