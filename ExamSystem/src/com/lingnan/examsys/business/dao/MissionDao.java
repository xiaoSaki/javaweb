package com.lingnan.examsys.business.dao;

import com.lingnan.examsys.common.dao.BaseDao;

public interface MissionDao extends BaseDao{
	public boolean insertMission(int exam_id, int user_id);
	/**
	 * 
	* <p>Title: updateMission</p>
	* <p>Description: 根据ans_id和user_id更新updateMission为完成</p>
	* @param ans_id
	* @param user_id
	* @return
	 */
	public int updateMission(int ans_id,int user_id);
}
