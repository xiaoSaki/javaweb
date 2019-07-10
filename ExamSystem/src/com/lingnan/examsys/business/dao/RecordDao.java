package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.RecordVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface RecordDao extends BaseDao {
	/**
	 * 黄润志2018.08.11
	 * 查看学生答题记录根据用户账号与用户名
	 * @param user  返回查找信息
	 * @return
	 */
	public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user);
	/**
	 * 
	 * 章节测试：由章节数生成试卷的题目，并录入对应的用户id和试卷id
	* @param user_id
	* @param exam_id
	* @param chapter
	* @return 第一题题目id
	 */
	public int createChapterTestRecord(int user_id,int exam_id,int chapter);
	/**
	 * 
	* <p>Title: getLastQueidByExamidAndUserid</p>
	* <p>Description:根据答题id和用户id获取未完成答题时的最新一题的id </p>
	* @param exam_id
	* @param user_id
	* @return
	 */
	public RecordVO getLastQueidByExamidAndUserid(int exam_id,int user_id);
	/**
	 * 
	* <p>Title: createChapterTestRecord</p>
	* <p>Description: 生成考试,题目一样但顺序不同的答题记录</p>
	* @param user_id
	* @param exam_id
	* @return int[0]：考试题目总数、int[1]第一题que_id
	 */
	public int[] createExamRecord(int user_id, int exam_id);
	/**
	 * 
	* <p>Title: getNumOfAnswer</p>
	* <p>Description: 获取答题的题数数量</p>
	* @param ans_id
	* @return
	 */
	public int getNumOfAnswer(int ans_id);
}
