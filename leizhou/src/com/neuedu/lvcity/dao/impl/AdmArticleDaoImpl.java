package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmArticleDao;
import com.neuedu.lvcity.dao.BackstageDao;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Article;

public class AdmArticleDaoImpl implements AdmArticleDao{
	
	private Connection conn;//数据库连接
	public AdmArticleDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Article> findArticle() {
		List<Article> list = new ArrayList<Article>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs= null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from article");
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){				
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAtid(rs.getInt("atid"));
				article.setArticlename(rs.getString("articlename"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setPublisher(rs.getInt("publisher"));
				article.setReleasetime((rs.getString("releasetime")));
				list.add(article);	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public boolean deleteArticle(int aid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("delete from article where aid = ?");
			pstam.setInt(1, aid);
			int i =pstam.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addArticle(Article article) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into article (aid,atid,articlename,content,image,publisher,releasetime) values(?,?,?,?,?,?,?) ");
			pstam.setInt(1, article.getAid());
			pstam.setInt(2, article.getAtid());
			pstam.setString(3, article.getArticlename());
			pstam.setString(4, article.getContent());
			pstam.setString(5, article.getImage());
			pstam.setInt(6, article.getPublisher());
			pstam.setString(7, article.getReleasetime());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
//			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}


	
		

	@Override
	public boolean updateArticle(Article article) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update article set aid=?,atid=?,articlename=?,content=?,image=?,publisher=?,releasetime=? where aid=? ");
			pstam.setInt(1, article.getAid());
			pstam.setInt(2, article.getAtid());
			pstam.setString(3, article.getArticlename());
			pstam.setString(4, article.getContent());
			pstam.setString(5, article.getImage());
			pstam.setInt(6, article.getPublisher());
			pstam.setString(7, article.getReleasetime());
			pstam.setInt(8, article.getAid());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新通知article的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public Article findArticleByid(int aid) {
		Article article = new Article();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from article where aid = ?");
			pstam.setInt(1, aid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段			
			while(rs.next()){
				article.setAid(rs.getInt("aid"));
				article.setAtid(rs.getInt("atid"));
				article.setArticlename(rs.getString("articlename"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setPublisher(rs.getInt("publisher"));
				article.setReleasetime((rs.getString("releasetime")));	
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询用户article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return article;
	}

	@Override
	public int getCountByAll() {
		//声明变量，用于保存查询结果
		int result = 0;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select count(*) from article");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}


}
