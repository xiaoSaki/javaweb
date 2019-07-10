package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Notice;

public interface NoticeService {
	//按公告分类查找此分类下的公告数量
		public int getCountByFtid(int ntid);
		//按公告分类查找此分类下的公告集合,从第start条开始
		public List<Notice> noticeListByFtid(int ntid,int start);
		
		//统计满足模糊查询数量
		public int getCountByLike(String like,int ftid);
		//查询满足模糊查询的公告集合
		public List<Notice> noticeListByLike(String like,int ntid,int start);
}
