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
import com.neuedu.lvcity.service.HistoricService;
import com.neuedu.lvcity.service.impl.HistoricServiceImpl;


public class HistoricTextServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		HistoricService historicService = HistoricServiceImpl.getInstance();
		String _aid = req.getParameter("aid");
		
		if(_aid.equals("")) {
			int pageNow = Integer.parseInt(req.getParameter("pageNow"));
			System.out.println(pageNow);
			List<Article> la = new ArrayList<Article>();
			la = historicService.findArticleByPage(pageNow, 10);
			s.setAttribute("HistoricleList", la);
			s.setAttribute("pageNow", pageNow);
			resp.sendRedirect("/lvcityFG/User/historiclist.jsp");
		}
		else {
			int aid = Integer.parseInt(_aid);
			int pageNow = Integer.parseInt(req.getParameter("pageNow"));	
			Article a = new Article();
			a = historicService.findArticleByAid(aid);
			s.setAttribute("article", a);
			s.setAttribute("pageNow", pageNow);
			resp.sendRedirect("/lvcityFG/User/historictext.jsp");
		}		
	}
}
