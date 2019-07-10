package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.LoginService;
import com.neuedu.lvcity.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet  {
		
	// 所有从页面传过来的参数都在req里面
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.从页面获取我们想要的数据
		req.setCharacterEncoding("utf-8");
		int status = 2;
		String name = req.getParameter("name");
		String passwd = req.getParameter("passwd");		
		System.out.println("1." + name + " " + passwd);
		HttpSession s = req.getSession();
		
		// 2.调用后台的业务逻辑判断用户名和密码是否存在且与之相对应	
		LoginService loginService = new LoginServiceImpl();
		List<Users> list = loginService.loginByUser(name, passwd);
		//if(list.equals(null))
		
		String surpower = "2";
		for (Users user : list) {
			status = user.getStatus();
			s.setAttribute("user", user);
			if(status==1)
			{ 
				surpower = "1";
				System.out.print(surpower);
				s.setAttribute("surpower", surpower);
			}else{
				surpower = "2";
				System.out.print(surpower);
				s.setAttribute("surpower", surpower);
			}
			
		}
		System.out.println("status取值"+status);
		
		
		// 3.根据结果找到相应的页面
		if (status == 0) {
			resp.sendRedirect(req.getContextPath() + "/User/index.jsp"); // req.getContextPath()取OK.html的工程路径		
		}if (status == 1) {
			resp.sendRedirect(req.getContextPath() + "/Admin/index.jsp");	
		}if (status == 2) {
			
			resp.sendRedirect(req.getContextPath() + "/login_register.html");
		}	
	}
	
}
