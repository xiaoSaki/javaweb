package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Articletype;


public interface AdmArticletypeDao {
	public List<Articletype>findArticletype();
	public boolean deleteArticletype(int atid);//删除文章类型
	public boolean addArticletype(Articletype  admArticletype);//添加文章类型
	public Articletype findArticletypeByid(int  atid); //根据名称查找文章类型
	public boolean updateArticletype(Articletype  articletype);//更新文章类型

}
