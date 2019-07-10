package com.lingnan.examsys.business.service;

import com.lingnan.examsys.business.domain.RecordVO;

public interface RecordService {
	public int createChapterTestRecord(int user_id,int exam_id,int chapter);
	public RecordVO getLastQueidByExamidAndUserid(int exam_id, int user_id);
	public int[] createExamRecord(int user_id, int exam_id);
	public int getNumOfAnswer(int ans_id);
}
