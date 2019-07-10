package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.ScenicType;



public interface ScenicTypeDao {
	       //查询所有风景分类
			public List<ScenicType> findScenictype();
			
			//根据ftid编号查找美食分类名称
			public String  gettypebyid(int stid);
}
