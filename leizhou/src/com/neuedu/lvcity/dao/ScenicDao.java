package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Scenic;

public interface ScenicDao {

	//按风景分类查找此分类下的景点数量
		public int getCountByStid(int stid);
		//按风景分类查找此分类下的风景集合,从第start条开始
		public List<Scenic> scenicListByStid(int stid,int start);

		//统计满足模糊查询数量
		public int getCountByLike(String like,int stid);
		//查询满足模糊查询的风景集合
		public List<Scenic> scenicListByLike(String like,int stid,int start);
}
