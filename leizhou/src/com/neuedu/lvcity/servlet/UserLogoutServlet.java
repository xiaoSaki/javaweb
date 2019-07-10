package com.neuedu.lvcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("已退出系统.........");
		HttpSession s = req.getSession();
		s.invalidate();
		resp.sendRedirect(req.getContextPath()+"/login_register.html");
	}
	

}
