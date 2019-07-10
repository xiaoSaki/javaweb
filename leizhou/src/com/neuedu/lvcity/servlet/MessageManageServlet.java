package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.neuedu.lvcity.model.Message;
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.BackstageService;
import com.neuedu.lvcity.service.MessageService;
import com.neuedu.lvcity.service.impl.BackstageServiceImpl;
import com.neuedu.lvcity.service.impl.MessageServiceImpl;

public class MessageManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public MessageManageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findMessage".equals(action)){
			List<Message> list = new ArrayList<Message>();
			HttpSession s = req.getSession();
			MessageService messageService = new MessageServiceImpl();
			list = messageService.findallMessage();
			s.setAttribute("messageList", list);
			resp.sendRedirect("message_management.jsp");
		}if("addMessage".equals(action)){
			System.out.println("jkajxkhk");
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String tel = req.getParameter("tel");
			String message1 = req.getParameter("message");
			Message message = new Message();
			message.setName(name);
			message.setSex(sex);
			message.setTel(tel);
			message.setMessage(message1);			
			MessageService messageService = new MessageServiceImpl();
			boolean flag = messageService.AddListMessage(message);
			if(flag){
				resp.sendRedirect("messageManageServlet?action=findMessage");
			}else{
				resp.sendRedirect("message_management_add.jsp");
			}
		}if("deleteMessage".equals(action)){
			int mid = Integer.parseInt(req.getParameter("mid"));
			System.out.println("id测试"+mid);
			MessageService messageService = new MessageServiceImpl();
			boolean flag = messageService.deleteMessage(mid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除留言成功");
				resp.sendRedirect("messageManageServlet?action=findMessage");
			}			
		}if("deleteCheckMessage".equals(action)){
			String[] arr1 = req.getParameterValues("arr");
			MessageService messageService = new MessageServiceImpl();
			for(String a : arr1){
				String[] b = a.split(",");   //用","对数组a进行分割
				for(String c : b)
					messageService.deleteMessage(Integer.parseInt(c));
			}
			resp.sendRedirect("messageManageServlet?action=findMessage");
		}if("findMessageByName".equals(action)){
			String name = req.getParameter("name");
			List<Message> list = new ArrayList<Message>();
			HttpSession s = req.getSession();
			MessageService messageService = new MessageServiceImpl();
			list = messageService.findMessage(name);
			s.setAttribute("messageList", list);
			resp.sendRedirect("Message_management.jsp");
		}if("findupdateMessage".equals(action)){
			int mid = Integer.parseInt(req.getParameter("mid").trim());
			HttpSession s = req.getSession();
			MessageService messageService = new MessageServiceImpl();
			Message messages = messageService.findMessageById(mid);
			s.setAttribute("messages", messages);
			resp.sendRedirect("message_management_update.jsp");
		}if("updateMessage".equals(action)){
			HttpSession s = req.getSession();
			MessageService messageService = new MessageServiceImpl();
			int mid = Integer.parseInt(req.getParameter("mid"));
			System.out.println("mid测试:"+mid);
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");			
			String tel = req.getParameter("tel");
			String message = req.getParameter("message");
			Message messages = new Message();
			messages.setMid(mid);
			messages.setName(name);
			messages.setSex(sex);
			messages.setTel(tel);
			messages.setMessage(message);
			boolean flag = messageService.updateMessage(messages);
			if(flag){
				resp.sendRedirect("messageManageServlet?action=findMessage");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}
		
	}
	
}
