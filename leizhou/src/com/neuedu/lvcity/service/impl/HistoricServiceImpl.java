package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.HistoricDao;
import com.neuedu.lvcity.dao.impl.HistoricDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.service.HistoricService;

public class HistoricServiceImpl implements HistoricService{

	private static HistoricService historicService = new HistoricServiceImpl();
	
	
	private HistoricServiceImpl() {
		
	}
	
	public static HistoricService getInstance() {
		return historicService;
	}
	
	@Override
	public List<Contact> findContact() {
		List<Contact> lc = new ArrayList<Contact>();
		Connection conn = null;
		conn = DBUtils.getConnection();
		HistoricDao ha = new HistoricDaoImpl(conn);
		lc = ha.findContact();
		return lc;
	}

	@Override
	public List<Article> findArticle() {
		List<Article> la = new ArrayList<Article>();
		Connection conn = null;
		conn = DBUtils.getConnection();
		HistoricDao ha = new HistoricDaoImpl(conn);
		la = ha.findArticle();
		return la;
	}

	@Override
	public List<Articletype> findArticleType() {
		List<Articletype> la = new ArrayList<Articletype>();
		Connection conn = null;
		conn = DBUtils.getConnection();
		HistoricDao ha = new HistoricDaoImpl(conn);
		la = ha.findArticleType();
		return la;
	}

	@Override
	public Article findArticleByAid(int aid) {
		Article a = new Article();
		Connection conn = null;
		conn = DBUtils.getConnection();
		HistoricDao ha = new HistoricDaoImpl(conn);
		a = ha.findArticleByAid(aid);
		return a;
	}

	@Override
	public List<Article> findArticleByPage(int pageNow, int pageSize) {
		List<Article> la = new ArrayList<Article>();
		Connection conn = null;
		conn = DBUtils.getConnection();
		HistoricDao ha = new HistoricDaoImpl(conn);
		la = ha.findArticleByPage(pageNow, pageSize);
		return la;
	}

}
