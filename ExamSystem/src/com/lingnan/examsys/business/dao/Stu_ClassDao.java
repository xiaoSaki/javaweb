package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface Stu_ClassDao extends BaseDao {
	/**
	 * 统计班级人数
	 * @param class_name
	 * @return
	 */
	public int findSTNumberByCn(String class_name);
	/**
	 * 删除学生
	 * @param user_id
	 * @return
	 */
	public boolean  deleteStuByUserID(int user_id);
	/**
	 * 查看该学生是否存在
	 * @param user_id
	 * @param class_id
	 * @return
	 */
	public boolean  findStuClass(int user_id,int class_id);
	/**
	 * 添加学生
	 * @param user_id
	 * @param class_id
	 * @return
	 */
	public boolean insertStuClass(int user_id,int class_id);
	
	
	public List<Stu_ClassVO> findExam_Stu(int class_id);
}
