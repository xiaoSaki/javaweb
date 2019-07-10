package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.TeamVO;



public interface AdmTeamDao {
	public List<TeamVO >findTeam();
	public boolean deleteTeam(int teamid);//删除公告
	public boolean addTeam(TeamVO  teamVO );//添加公告
	public TeamVO findTeamByid(int  teamid); //根据名称查找公告
	public boolean updateTeam(TeamVO  TeamVO );//更新公告
}
