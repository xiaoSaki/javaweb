package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Noticetype;

public interface AdmNoticeTypeDao {

	//公告类型管理
	public List<Noticetype> findNoticetype();//查找公告类型
	public boolean deleteNoticetype(int ntid);//删除公告类型
	public boolean addNoticetype(Noticetype noticetype);//添加公告类型
	public List<Noticetype> findNoticetypeByName(String nt); //根据名称查找公告类型
	public Noticetype findNoticetypeByid(int  ntid); //根据名称查找公告类型
	public boolean updateNoticetype(Noticetype noticetype);//更新公告类型
	

}
