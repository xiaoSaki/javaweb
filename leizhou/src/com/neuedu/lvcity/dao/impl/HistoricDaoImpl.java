package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.HistoricDao;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Contact;

public class HistoricDaoImpl implements HistoricDao{

	private Connection conn = null;
	
	public HistoricDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Contact> findContact() {
		ResultSet rs = null;
		Statement stmt = null;
		List<Contact> lc = new ArrayList<Contact>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from contact";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Contact c = new Contact();
				System.out.println(rs.getString("address"));
				c.setAddress(rs.getString("address"));
				c.setContactid(rs.getInt("contactid"));
				c.setContactname(rs.getString("contactname"));
				c.setFax(rs.getString("fax"));
				c.setQq(rs.getString("qq"));
				c.setTel(rs.getString("tel"));
				c.setWeb(rs.getString("web"));
				c.setZipcode(rs.getString("zipcode"));
				lc.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}
		return lc;
	}

	@Override
	public List<Article> findArticle() {
		ResultSet rs = null;
		Statement stmt = null;
		List<Article> la = new ArrayList<Article>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from article where atid = 1";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Article a = new Article();
				a.setAid(rs.getInt("aid"));
				a.setArticlename(rs.getString("articlename"));
				a.setAtid(rs.getInt("atid"));
				a.setContent(rs.getString("content"));
				a.setImage(rs.getString("image"));
				a.setPublisher(rs.getInt("publisher"));
				a.setReleasetime(rs.getString("releasetime"));
				la.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}
		return la;
	}

	@Override
	public List<Article> findArticleByPage(int pageNow, int pageSize) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Article> la = new ArrayList<Article>();
		try {
			prep = conn.prepareStatement("select * from article limit ?,?;");
			prep.setInt(1, pageSize*(pageNow-1));
			prep.setInt(2, pageSize);
			rs = prep.executeQuery();		
			while(rs.next()) {
				Article a = new Article();
				a.setAid(rs.getInt("aid"));
				a.setArticlename(rs.getString("articlename"));
				a.setAtid(rs.getInt("atid"));
				a.setContent(rs.getString("content"));
				a.setImage(rs.getString("image"));
				a.setPublisher(rs.getInt("publisher"));
				a.setReleasetime(rs.getString("releasetime"));
				la.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, prep);
		}
		return la;
	}
	
	@Override
	public List<Articletype> findArticleType() {
		ResultSet rs = null;
		Statement stmt = null;
		List<Articletype> la = new ArrayList<Articletype>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from articletype";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Articletype a = new Articletype();
				a.setAtid(rs.getInt("atid"));
				a.setAtype(rs.getString("atype"));
				la.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}
		return la;
	}

	@Override
	public Article findArticleByAid(int aid) {
		ResultSet rs = null;
		Statement stmt = null;
		Article a = new Article();
		try {
			stmt = conn.createStatement();
			String sql = "select * from article where aid = "+aid;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setArticlename(rs.getString("articlename"));
				a.setAtid(rs.getInt("atid"));
				a.setContent(rs.getString("content"));
				a.setImage(rs.getString("image"));
				a.setPublisher(rs.getInt("publisher"));
				a.setReleasetime(rs.getString("releasetime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}
		return a;
	}
	
}
