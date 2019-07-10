package com.lingnan.examsys.business.dao;

import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ExamInfoPOJO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface ExaminationDao extends BaseDao {
	/**
	 * 黄润志
	 *  查找该老师出的所有试卷
	 * @param user_id
	 * @param class_name
	 * @return
	 */

	public List<ExaminationVO> findExamByUid(int user_id,String class_name);
	/**
	 * 统计完成人数
	 * @param exam_id
	 * @return
	 */
	public int findFinishSt(int exam_id);
	/**
	 * 查看学生完成状态
	 * @param exam_id
	 * @return
	 */
	public List<StuFinishStatusVO> findStuStatus(int exam_id);
	/**
	 * 诗卉
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间）
	 * 2.根据教师编号和试卷名从试卷表中（examination）找出试卷号（主键，自增）
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
	public List<ExaminationVO> findExamByexam_id(int exam_id);  //根据exam_id查找试卷  add 2018/11/17
	public boolean updateExam(ExaminationVO ExamVO);  //更新试卷信息 add 2018/11/17
	/**
	 * 根据分页大小获取最大页数
	 * @param pageSize 分页大小
	 * @return 最大页数
	 */
	public int getMaxpageByPagesize(int pageSize);
	/**
	 * qi
	 * 分页获取考试信息
	 * @param pageNo 页号
	 * @param pageSize 分页大小
	 * @return 分页考试信息
	 */
	public ArrayList<ExaminationVO> getExamByPage(int pageNo,int pageSize);
	
	
	/**
	 * 2018年10月21日10:28:42
	 */
	
	
	/**
	 * 章节测试：新增一张试卷并返回主键id
	 * @return 生成的试卷
	 */
	public ExaminationVO addExam(int chapter);
	/**
	 * 
	* <p>Title: getExamById</p>
	* <p>Description: 根据exam_id获取考试表记录</p>
	* @param exam_id
	* @return
	 */
	public ExaminationVO getExamById(int exam_id);
	/**
	 * 
	* <p>Title: getExamByAnsid</p>
	* <p>Description: 根据ans_id获取考试表记录</p>
	* @param ans_id
	* @return
	 */
	public ExaminationVO getExamByAnsid(int ans_id);
	/**
	 * 
	* <p>Title: getExaminfoByUserid</p>
	* <p>Description: </p>
	* @param user_id
	* @return
	 */
	public List<ExamInfoPOJO> getExaminfoByUserid(int user_id);
	/**
	 * 
	* <p>Title: getExaminfoWithPage</p>
	* <p>Description: 分页获取考试信息以及学生的完成状态记录</p>
	* @param user_id
	* @param pageNo
	* @param pageSize
	* @return
	 */
	public List<ExamInfoPOJO> getExaminfoWithPage(int user_id, int pageNo, int pageSize);

}
