package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.service.AdmArticleService;
import com.neuedu.lvcity.service.impl.AdmArticleServiceImpl;

public class AdmArticleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmArticleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findArticle".equals(action)){
			List<Article> list = new ArrayList<Article>();
			HttpSession s = req.getSession();
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			list = admArticleService.findArticle();
			s.setAttribute("articleList", list);
			resp.sendRedirect("article_management.jsp");
			//
			/*
			int pageSize = 9;//一页9条数据
			int rowCount = admArticleService.getCountByAll();//一共有几条数据
		
			if(rowCount == 0) {
				s.setAttribute("zwjl", "1");
			}
			int pageCount;//一共有多少页
			if(rowCount % pageSize == 0){
			    pageCount = rowCount/pageSize;
			}else{
			    pageCount = rowCount/pageSize + 1;
			}
			
			if(pageNow<1){
				pageNow=1;
			}
			if(pageNow>pageCount){
				pageNow=pageCount;
			}
			
			int start=0;
			if(pageNow==1){
				start=0;
			}else if (pageNow==0) {
				start=(pageNow)*pageSize;
				pageNow = 1;
				pageCount= 1;
			}else{
				start=(pageNow-1)*pageSize;
			}
			
			
			s.setAttribute("pageNow",pageNow);
			s.setAttribute("rowCount",rowCount);
			s.setAttribute("pageCount",pageCount);
			s.setAttribute("pageSize",pageSize);*/
			
		}if("deleteArticle".equals(action)){
			int aid = Integer.parseInt(req.getParameter("aid"));
			System.out.println("id测试"+aid);
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			boolean flag = admArticleService.deleteArticle(aid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("admArticleServlet?action=findArticle");
			}
			
		}if("addArticle".equals(action)){
			System.out.println("jkajxkhk");
			//int atid= Integer.parseInt(req.getParameter("atid"));
			String articlename = req.getParameter("articlename");
			String image = req.getParameter("image");
			String content = req.getParameter("content");
			String releasetime= req.getParameter("releasetime");
			int atid = Integer.parseInt(req.getParameter("atid"));
			int publisher = Integer.parseInt(req.getParameter("publisher"));
			Article article = new Article();

			article.setArticlename(articlename);
			article.setAtid(atid);
			article.setContent(content);
			article.setImage(image);
			article.setPublisher(publisher);
			article.setReleasetime(releasetime);
		
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			boolean flag = admArticleService.addArticle(article);
			if(flag){
				resp.sendRedirect("admArticleServlet?action=findArticle");
			}else{
				resp.sendRedirect("article_management_add.jsp");
			}
		}if("updateArticle".equals(action)){
			System.out.println("进入更新。。。。");
		
		
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			String articlename = req.getParameter("articlename");
			String image = req.getParameter("image");
			String content = req.getParameter("content");
			String releasetime= req.getParameter("releasetime");
			int atid = Integer.parseInt(req.getParameter("atid"));
			int aid = Integer.parseInt(req.getParameter("aid"));
			System.out.print("yemianhuoqu"+aid);
			int publisher = Integer.parseInt(req.getParameter("publisher"));
			Article article = new Article();
			
			article.setArticlename(articlename);
			article.setAtid(atid);
			article.setAid(aid);
			article.setContent(content);
			article.setImage(image);
			article.setPublisher(publisher);
			article.setReleasetime(releasetime);
		     System.out.print("...fffff"+article.getAid()); 
			boolean flag = admArticleService.updateArticle(article);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admArticleServlet?action=findArticle");
			}else{
				JOptionPane.showMessageDialog(null, "更新文章失败");
			}
		}if("findupdateArticle".equals(action)){
			int aid = Integer.parseInt(req.getParameter("aid").trim());
			System.out.print("===kkk"+aid);
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			Article article = admArticleService.findArticleByid(aid);
			s.setAttribute("article", article);
			System.out.print("===jjj"+article.getAtid());
			//resp.sendRedirect(req.getContextPath()+"article_management_update.jsp");
			resp.sendRedirect("article_management_update.jsp");
		}if("findArticleByid".equals(action)){
			Article article = new Article();
			HttpSession s = req.getSession();
			int aid = Integer.parseInt(req.getParameter("aid").trim());
			AdmArticleService admArticleService = new AdmArticleServiceImpl();
			article = admArticleService.findArticleByid(aid);
			s.setAttribute("article", article);
			System.out.print("hhhh"+aid);
			resp.sendRedirect("article_managementByid.jsp");
			
		}
	}

}
