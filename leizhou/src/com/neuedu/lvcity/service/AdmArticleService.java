package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Article;

public interface AdmArticleService {

	//公告管理
	public List<Article> findArticle();//查找公告
	public boolean deleteArticle(int aid);//删除公告
	public boolean addArticle(Article article);//添加公告
	public Article findArticleByid(int aid);
	public boolean updateArticle(Article article);//更新公告
	//统计数量
	public int getCountByAll();
}
