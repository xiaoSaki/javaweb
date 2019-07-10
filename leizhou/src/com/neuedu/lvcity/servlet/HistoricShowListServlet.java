package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.service.HistoricService;
import com.neuedu.lvcity.service.impl.HistoricServiceImpl;



public class HistoricShowListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		HistoricService historicService = HistoricServiceImpl.getInstance();
		List<Article> la = new ArrayList<Article>();
		List<Article> all = new ArrayList<Article>();
		int aid=18;
		all = historicService.findArticle();
		la = historicService.findArticleByPage(pageNow, 10);		
		s.setAttribute("pageSize", 10);
		s.setAttribute("pageNow", pageNow);
		s.setAttribute("pageCount", (int)((all.size()/10)+1));
		s.setAttribute("HistoricleList", la);
		s.setAttribute("rowCount", all.size());
		s.setAttribute("aid", 18);
		Article a = new Article();
		a = historicService.findArticleByAid(aid);
		s.setAttribute("article", a);
	/*	resp.sendRedirect("/lvcityFG/User/historiclist.jsp");*/
		resp.sendRedirect("/lvcityFG/User/historictext.jsp");
	}
}
