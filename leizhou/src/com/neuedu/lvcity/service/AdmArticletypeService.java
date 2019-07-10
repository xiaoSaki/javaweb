package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Articletype;

public interface AdmArticletypeService {

	//公告管理
	public List<Articletype> findArticletype();//查找公告
	public boolean deleteArticletype(int atid);//删除公告
	public boolean addArticletype(Articletype articletype);//添加公告
	public Articletype findArticletypeByid(int id);
	public boolean updateArticletype(Articletype articletype);//更新公告
}
