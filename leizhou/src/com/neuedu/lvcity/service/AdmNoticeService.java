package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Notice;

public interface AdmNoticeService {

	//公告管理
	public List<Notice> findNotice();//查找公告
	public boolean deleteNotice(int nid);//删除公告
	public boolean addNotice(Notice notice);//添加公告
	public List<Notice> findNoticeByname(String name);
	public Notice findNoticeByid(int id);
	public boolean updateNotice(Notice notice);//更新公告
}
