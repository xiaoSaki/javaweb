package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;



public class ContactServlet extends HttpServlet {
	/**
	 * 构造方法？？？
	 */
	public ContactServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest requset, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(requset.getContextPath());
		doPost(requset, response);
	}
	
	/**
	 @see HttpServlet#doGetdoPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//防止取中文参数出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
	    //显示左边所有美食分类
		if("show".equals(action)){
			doShow(request,response);
     	//显示对应分类下面的各种美食列表
		}else if("map".equals(action)){
			doMap(request,response);
		}
	}
	
	private void doMap(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/User/map.jsp");
	}
	private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取session
		HttpSession session = request.getSession();
		//调用Service方法
		ContactService contactService = ContactServiceImpl.getInstance();
		Contact contact = contactService.findContactById(1);
		session.setAttribute("contact",contact);
		response.sendRedirect(request.getContextPath()+"/User/connection.jsp");
	}
}

