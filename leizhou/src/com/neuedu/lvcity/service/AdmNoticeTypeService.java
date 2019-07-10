package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Noticetype;

public interface AdmNoticeTypeService {

	//公告管理
	public List<Noticetype> findNoticetype();//查找公告
	public boolean deleteNoticetype(int ntid);//删除公告
	public boolean addNoticetype(Noticetype noticetype);//添加公告
	public List<Noticetype> findNoticetypeByname(String nt);
	public Noticetype findNoticetypeByid(int ntid);
	public boolean updateNoticetype(Noticetype noticetype);//更新公告
}
