package com.lingnan.examsys.business.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ExamInfoPOJO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.PageBean;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.business.domain.Question_bankVO;


public interface ExaminationService {

	/**
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间）
	 * 2.根据教师编号和试卷名从试卷表中（examination）找出试卷号（主键，自增）
	 */
//	public boolean insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end);
//	public int findExam_id(int user_id, String exam_name);
	/**
	 * 2018/10/29 mai 修改
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间，user_id从页面取）,返回exam_id
	 */
	public List<ExaminationVO> findExamByid(int user_id);  //查询该教师出过的试卷
	public List<ExaminationVO> findExamByName(int user_id,String exam_name); //根据试卷名模糊查询试卷
    public int insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end);
	public List<Que_ExamVO> findQueByexam_id(int exam_id);  //根据试卷id查找试题id
	public List<Question_bankVO> findQueByque_id(int a[]);  //根据试卷id查找到的试题id去查询试题详情
	public boolean delExam_Que(int exam_id,int que_id);  //删除试卷中的试题(que_exam表)
	public List<Question_bankVO> findQueByid(int que_id);  //根据que_id查询试题
	public boolean updateQue_bank(Question_bankVO Que_bankVO);  //更新试题
	public boolean insertQueByid(int exam_id,int que_id);  //题库添加试卷试题
	
	public boolean delQue_ExamByid(int exam_id);  //根据exam_id删除试题记录 add 2018/11/17
	public boolean delExamByid(int exam_id);  //根据exam_id删除试卷 add 2018/11/17
	public boolean updateExam(ExaminationVO ExamVO);  //更新试卷信息 add 2018/11/17
	public List<ExaminationVO> findExamByexam_id(int exam_id);  //根据exam_id查找试卷  add 2018/11/17

	/**
	 * qi
	 * 按照分页大小获取最大分页数
	 * @param pageSize
	 * @return
	 */
	public int getMaxpageByPagesize(int pageSize);
	/**
	 * 分页获取考试信息
	 * @param pageNo 请求的起始页号
	 * @param pageSize 分页大小
	 * @return 考试信息集合
	 */
	public ArrayList<ExaminationVO> getExamByPage(int pageNo,int pageSize);
	public ExaminationVO getExamById(int exam_id);
	public ExaminationVO getExamByAnsid(int ans_id);
	/**
	 * 
	* <p>Title: getExamInfo</p>
	* <p>Description: 根据user_id分页获取所有的考试信息以及完成情况并生成PageBean对象</p>
	* @param user_id
	* @param pageNo
	* @param pageSize
	* @return
	 */
	public PageBean<ExamInfoPOJO> getExamInfo(int user_id,int pageNo,int pageSize);
}
