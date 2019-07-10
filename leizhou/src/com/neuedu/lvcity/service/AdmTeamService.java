package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.TeamVO;

public interface AdmTeamService {

	//公告管理
	public List<TeamVO> findTeamVO();//查找公告
	public boolean deleteTeamVO(int ntid);//删除公告
	public boolean addTeamVO(TeamVO teamVO);//添加公告
	public TeamVO findTeamVOByid(int teamid);
	public boolean updateTeamVO(TeamVO teamVO);//更新公告
}
