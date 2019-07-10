package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Contact;

public interface HistoricDao {

	public List<Contact> findContact();
	public List<Article> findArticle();
	public List<Article> findArticleByPage(int pageNow, int pageSize);
	public List<Articletype> findArticleType();
	public Article findArticleByAid(int aid);
	
}
