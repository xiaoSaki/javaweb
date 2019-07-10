package com.neuedu.lvcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.LoginService;
import com.neuedu.lvcity.service.impl.LoginServiceImpl;

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    //所有从页面register.html传过来的参数都在req里面
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String passwd = req.getParameter("passwd");
			System.out.println("1."+name+" "+passwd);
			
			//2.调用后台的业务逻辑进行注册
			LoginService loginService = new LoginServiceImpl();
			Users user = new Users();
			user.setName(name);
			user.setPasswd(passwd);
			boolean flag = loginService.RegisterUser(name, passwd);
			
			System.out.println("flag测试"+flag);						
			//3.根据结果找到相应的页面
			if(flag)
			{
				resp.sendRedirect(req.getContextPath()+"/login_register.html");
				}
//			else
//				resp.sendRedirect(req.getContextPath()+"/Admin/registerServlet");
		}
}
