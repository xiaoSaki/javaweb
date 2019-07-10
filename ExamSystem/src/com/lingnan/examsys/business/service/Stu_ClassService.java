package com.lingnan.examsys.business.service;

import java.util.List;

import com.lingnan.examsys.business.domain.Stu_ClassVO;

public interface Stu_ClassService {

	public List<Stu_ClassVO> findExam_Stu(int class_id);
	/**
	 * 删除学生 2018.10.24huangrunzhi
	 * @param user_id
	 * @return
	 */
	public boolean deleteStuByUserID(int user_id); 
	/**
	 * 查看该学生是否存在
	 * @param user_id
	 * @param class_id
	 * @return
	 */
	public boolean findStuClassByClassidAndUserid(int user_id,int class_id);
	/**
	 * 添加学生
	 * @param user_id
	 * @param class_id
	 * @return
	 */
	public boolean insertStuClass(int user_id,int class_id);
}
