package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Notice;

public interface AdmNoticeDao {

	//公告管理
	public List<Notice> findNotice();//查找公告
	public boolean deleteNotice(int nid);//删除公告
	public boolean addNotice(Notice notice);//添加公告
	public List<Notice> findNoticeByName(String name); //根据名称查找公告
	public Notice findNoticeByid(int  nid); //根据名称查找公告
	public boolean updateNotice(Notice notice);//更新公告
	

}
