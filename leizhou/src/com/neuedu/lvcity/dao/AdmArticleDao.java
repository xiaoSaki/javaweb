package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Article;


public interface AdmArticleDao {
	public List<Article>findArticle();
	public boolean deleteArticle(int aid);//删除文章类型
	public boolean addArticle(Article  article);//添加文章类型
	public Article findArticleByid(int  aid); //根据名称查找文章类型
	public boolean updateArticle(Article  article);//更新文章类型
	//统计数量
	public int getCountByAll();

}
