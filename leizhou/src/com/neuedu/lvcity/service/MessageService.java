package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Message;

public interface MessageService {

	/**
	 * 添加留言信息
	 * @param messages
	 * @return
	 */
	public boolean AddListMessage(Message messages);
	
	public List<Message> findallMessage();
	
	public List<Message> findMessageByusername(String name);
	
	public boolean deleteMessage(int mid);
	public List<Message> findMessage(String name);//模糊查询
	public Message findMessageById(int mid);
	public boolean updateMessage(Message messages);
}
