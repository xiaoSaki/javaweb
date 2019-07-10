package com.lingnan.examsys.business.service;

import com.lingnan.examsys.business.domain.Question_bankVO;

public interface Quetion_bankService {
	public Question_bankVO getQuetionById(int que_id);
	public int checkAnswer(int que_id,String answer);
	public String getAnswerbById(int que_id);
	public int getMaxChapterNum();
}
