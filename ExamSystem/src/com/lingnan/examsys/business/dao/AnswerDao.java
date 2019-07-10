package com.lingnan.examsys.business.dao;

import java.sql.Timestamp;
import java.util.List;

import com.lingnan.examsys.business.domain.AnswerRecordPOJO;
import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface AnswerDao extends BaseDao{
	/**
	* 学生开始章节考试，随机生成ans_id和que_id
	* @param used_id 
	* @param chapter 
	* @return 生成的答题信息
	 */
	public AnswerVO chapterTest(int used_id,int chapter);
	
	/**
	 * 
	* <p>Title: getErrorsumById</p>
	* <p>Description: 根据id获取答题的答错次数</p>
	* @param ans_id
	* @return
	 */
	public int getErrorsumById(int ans_id);
	
	/**
	 * 
	* <p>Title: getErrorsumById</p>
	* <p>Description: 根据id设置答题的答错次数</p>
	* @param ans_id
	* @param set
	* @return
	 */
	public int setErrorsumById(int ans_id,int set);
	
	/**
	 * 
	* <p>Title: setEndtimeById</p>
	* <p>Description:根据id设置答题的结束时间</p>
	* @param ans_id
	* @param endtime
	* @return
	 */
	public int setEndtimeById(int ans_id,Timestamp endtime);
	
	/**
	 * 
	* <p>Title: updateTimeOnRecordByAns_Id</p>
	* <p>Description: 根据ans_id、seq_num以及user_id检索到record记录并修改时间</p>
	* @param ans_id
	* @param time
	* @return
	 */
	public int updateTimeOnRecordByAns_Id(int ans_id,int user_id,int seq_num,Timestamp time);
	/**
	 * 
	* <p>Title: updateError_flagOnRecordByAns_Id</p>
	* <p>Description: 根据ans_id、seq_num以及user_id修改改答题记录的答题错误标志</p>
	* @param ans_id
	* @param user_id
	* @param seq_num
	* @param value
	* @return
	 */
	public int updateError_flagOnRecordByAns_Id(int ans_id,int user_id,int seq_num,int value);
	/**
	 * 
	* <p>Title: getAndPlusErrorsumById</p>
	* <p>Description: 根据ans_id，使error_sum加1并返回更新后的error_sum</p>
	* @param ans_id
	* @return
	 */
	public int getAndPlusErrorsumById(int ans_id);
	
	/**
	 * 
	* <p>Title: getNextQuetion</p>
	* <p>Description: 获取本次答题的下一道题目id</p>
	* @param ans_id
	* @param user_id
	* @param seq_num
	* @return
	 */
	public int getNextQuetion(int ans_id,int user_id,int seq_num);
	/**
	 * 
	* <p>Title: ifExistAnswering</p>
	* <p>Description: 检验该学生是否有未完成的考试，无则返回0，有则返回该的ans_id</p>
	* @param user_id
	* @return
	 */
	public int ifExistAnswering(int user_id);
	/**
	 * 
	* <p>Title: getAnswerById</p>
	* <p>Description: 根据Id获取答题信息</p>
	* @param ans_id
	* @return
	 */
	public AnswerVO getAnswerById(int ans_id);
	/**
	 * 
	* <p>Title: getTypeOfAnswerById</p>
	* <p>Description: 根据Id判断答题类型类型</p>
	* @param ans_id
	* @return 1：章节测试；2：考试
	 */
	public int getTypeOfAnswerById(int ans_id);
	
	/**
	 * 
	* <p>Title: examTest</p>
	* <p>Description: 生成考试的answer记录</p>
	* @param user_id
	* @param exam_id
	* @return
	 */
	public AnswerVO examTest(int user_id,int exam_id);
	/**
	 * 
	* <p>Title: getExamRecordByUserid</p>
	* <p>Description: 根据user_id分页获取其答题数据记录</p>
	* @param user_id
	* @return
	 */
	public List<AnswerRecordPOJO> getExamRecordWithPage(int user_id, int pageNo, int pageSize);
	public List<AnswerRecordPOJO> getChapterRecordWithPage(int user_id, int pageNo, int pageSize);
	public List<AnswerRecordPOJO> getExamRecordByUserid(int user_id);
	public List<AnswerRecordPOJO> getChapterRecordByUserid(int user_id);

}
