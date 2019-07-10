package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.ScenicType;

public interface ScenicTypeService{
	//查询所有风景分类
	public  List<ScenicType> findScenictype();
	
	//根据stid编号查找风景分类名称
	public String  gettypebyid(int stid);
}
