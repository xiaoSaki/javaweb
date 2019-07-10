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



public class HistoricServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		HistoricService historicService = HistoricServiceImpl.getInstance();
		List<Contact> lc = new ArrayList<Contact>();
		List<Article> la = new ArrayList<Article>();
		lc = historicService.findContact();
		la = historicService.findArticle();
		Contact c = new Contact();
		c = lc.get(0);
		s.setAttribute("contact", c);
		s.setAttribute("articleList", la);
		resp.sendRedirect("/lvcityFG/User/historic.jsp");
	}
}
