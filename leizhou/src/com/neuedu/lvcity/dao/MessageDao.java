package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Message;
import com.neuedu.lvcity.model.Notice;

public interface MessageDao {

	/**
	 * 添加留言，存进数据库
	 * @param messages 留言信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean AddListMessage(Message messages);

	/**
	 * 查询最大的mid编号
	 * @return 最大的mid
	 */
	public int findMaxMid();
	/*
	 * 查看所有留言
	 */
	public List<Message> findallMessage();
	
	public List<Message> findMessageByusername(String name);
	public boolean deleteMessage(int mid);
	public List<Message> findMessage(String name);//模糊查询
	public Message findMessageById(int mid);
	public boolean updateMessage(Message messages);
}
