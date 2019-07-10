package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.model.Message;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;
import com.neuedu.lvcity.service.impl.FoodTypeServiceImpl;
import com.neuedu.lvcity.service.impl.MessageServiceImpl;

public class LeaveServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public LeaveServlet(){
		super();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().append("Served at").append(req.getContextPath());
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//防止取中文参数出现乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
String action = req.getParameter("action");
		
    //显示左边所有美食分类
	if("showList".equals(action)){
		doShowList(req,resp);
	}else if("rightshow".equals(action)){
		doRightShow(req,resp);
	}else if("show".equals(action)){
		domessageList(req,resp);
	}else if("search".equals(action)){
		doSearch(req,resp);
	}
}
	
	
	
	
	
	private void doRightShow(HttpServletRequest req, HttpServletResponse resp) 	throws IOException{
		
		Message messages = new Message();

		String tel = req.getParameter("txtUserTel");
		String sex = req.getParameter("txtUserSex");
		String name = req.getParameter("txtUserName");
		String content = req.getParameter("txtContent");
		String yzm = req.getParameter("yzm");
		String check = req.getParameter("check");
		System.out.print("yangzhengma"+yzm);
		System.out.print("儿童团"+check);
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "还没有登录，你还不能留言呢");
			resp.sendRedirect(req.getContextPath()
					+"/User/leave.jsp");
		}else{
		
		HttpSession se = req.getSession();
		String bnwk = "true";
		String crcg = "true";
		crcg = "true";
		se.setAttribute("crcg", crcg);
		if(content.equals("")){
			JOptionPane.showMessageDialog(null, "留言内容不能为空");
			resp.sendRedirect(req.getContextPath()
					+"/User/leave.jsp");
		}
		if(!check.equals(yzm)&&!content.equals("")){
			try{
			JOptionPane.showMessageDialog(null, "验证码有误！");
			}catch(Exception e){
			resp.sendRedirect(req.getContextPath()
					+"/User/leave.jsp");
			}finally{
				resp.sendRedirect(req.getContextPath()
						+"/User/leave.jsp");
			}
		}if(!content.equals("")&&check.equals(yzm)){
			bnwk = "true";
		    se.setAttribute("bnwk", bnwk);
		    messages.setTel(tel);
			messages.setSex(sex);
			messages.setName(name);
			messages.setMessage(content);
			MessageServiceImpl messageService = new MessageServiceImpl();
			boolean flag = messageService.AddListMessage(messages);
			if(flag==true){
				JOptionPane.showMessageDialog(null, "留言内容成功！");
				resp.sendRedirect(req.getContextPath()
						+"/User/leave.jsp");
			}
			}
		
			
		}
	
	}
		
	private void doShowList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session
		HttpSession se = req.getSession();
		
		// 调用Service方法
		ContactService contactService = ContactServiceImpl.getInstance();
		
		//联系方式处
		Contact contact = contactService.findContact();
		se.setAttribute("contact",contact);

		 resp.sendRedirect(req.getContextPath()
					+ "/User/leave.jsp");
	}
	
	
	private void domessageList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session
		HttpSession se = req.getSession();
		MessageServiceImpl messageService = new MessageServiceImpl();
		 List<Message> messagearticleList=messageService.findallMessage();
			se.setAttribute("messagearticleList", messagearticleList);
		 resp.sendRedirect(req.getContextPath()
					+ "/User/leavelist.jsp");
	}
	/*
	 * 根据用户查找
	 */
	private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session
		HttpSession se = req.getSession();
		String name = req.getParameter("name");
		MessageServiceImpl messageService = new MessageServiceImpl();
		 List<Message> messagearticleList=messageService.findMessageByusername(name);
			se.setAttribute("messagearticleList", messagearticleList);
		 resp.sendRedirect(req.getContextPath()
					+ "/User/leavelist.jsp");
	}	
		
		
}

