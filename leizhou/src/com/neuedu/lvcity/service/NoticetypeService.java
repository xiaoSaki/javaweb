package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Noticetype;

public interface NoticetypeService {
	//查询所有美食分类
	public  List<Noticetype> findNoticetype();
	
	//根据ntid编号查找公告分类名称
	public  String  gettypebyid(int ntid);
	
}
