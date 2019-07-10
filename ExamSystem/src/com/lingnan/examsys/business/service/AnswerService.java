package com.lingnan.examsys.business.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.lingnan.examsys.business.domain.AnswerRecordPOJO;
import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.business.domain.PageBean;

public interface AnswerService {
	public AnswerVO chapterTest(int user_id,int chapter);
	public int getErrorsumById(int ans_id);
	public int setErrorsumById(int ans_id,int set);
	public int setEndtimeById(int ans_id,Timestamp endtime);
	public int updateTimeOnRecordByAns_Id(int ans_id,int user_id,int seq_num,Timestamp time);
	public int getAndPlusErrorsumById(int ans_id);
	public int getNextQuetion(int ans_id,int user_id,int seq_num);
	public int updateErrorflagOnRecordByAns_Id(int ans_id,int user_id,int seq_num,int value);
	public int ifExistAnswering(int user_id);
	public AnswerVO getAnswerById(int ans_id);
	public int getTypeOfAnswerById(int ans_id);
	public AnswerVO examTest(int user_id,int exam_id);
	public int updateMission(int ans_id,int user_id);
	/**
	 * 
	* <p>Title: getExamRecordByPageNo</p>
	* <p>Description: 根据页码分页获取考试记录</p>
	* @param user_id
	* @param pageNo
	* @param pageSize
	* @return
	 */
	public PageBean<AnswerRecordPOJO> getExamRecordByPageNo(int user_id, int pageNo, int pageSize);
	public PageBean<AnswerRecordPOJO> getChapterRecordByPageNo(int user_id, int pageNo, int pageSize);
	public boolean insertMission(int exam_id, int user_id);
}
