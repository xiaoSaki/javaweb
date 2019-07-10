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

import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.BackstageService;
import com.neuedu.lvcity.service.impl.BackstageServiceImpl;

public class UserManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public UserManageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findUser".equals(action)){
			List<Users> list = new ArrayList<Users>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findUser();
			s.setAttribute("userList", list);
			resp.sendRedirect("user_management.jsp");
		}if("deleteUser".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println("id测试"+id);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.deleteUser(id);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("userManageServlet?action=findUser");
			}			
		}if("addUser".equals(action)){
			System.out.println("jkajxkhk");
			String name = req.getParameter("name");
			String passwd = req.getParameter("passwd");			
			int age = Integer.parseInt(req.getParameter("age"));
			String sex = req.getParameter("sex");
			String email = req.getParameter("email");
			int status = 0;
			String status1 = req.getParameter("status");
			if("管理员".equals("status1")){
				status = 1;
			}if("普通用户".equals("status1")){
				status = 0;
			}
			System.out.println("测试"+name+" "+passwd);
			Users user = new Users();
			user.setName(name);
			user.setPasswd(passwd);
			user.setAge(age);
			user.setSex(sex);
			user.setEmail(email);
			user.setStatus(status);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.addUser(user);
			if(flag){
				resp.sendRedirect("userManageServlet?action=findUser");
			}else{
				resp.sendRedirect("user_management_add.jsp");
			}
		}if("updateUser".equals(action)){
			System.out.println("进入更新。。。。");
			/*int id = Integer.parseInt(req.getParameter("id"));*/
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			String name = req.getParameter("name");
			String passwd = req.getParameter("passwd");			
			int age = Integer.parseInt(req.getParameter("age"));
			String sex = req.getParameter("sex");
			String email = req.getParameter("email");
			int status = 0;
			String status1 = req.getParameter("status");
			int id = Integer.parseInt(req.getParameter("id"));
			if("管理员".equals("status1")){
				status = 1;
			}if("普通用户".equals("status1")){
				status = 0;
			}
			System.out.println("测试"+name+" "+passwd);
			Users user = new Users();
			user.setName(name);
			user.setPasswd(passwd);
			user.setAge(age);
			user.setSex(sex);
			user.setEmail(email);
			user.setStatus(status);
			user.setId(id);
			System.out.println("1111"+age);
			boolean flag = backstageService.updateUser(user);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("userManageServlet?action=findUser");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}if("findupdateUser".equals(action)){
			int id = Integer.parseInt(req.getParameter("id").trim());
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			Users user = backstageService.findUserById(id);
			s.setAttribute("user", user);
			//resp.sendRedirect(req.getContextPath()+"user_management_update.jsp");
			resp.sendRedirect("user_management_update.jsp");
		}if("findUserByName".equals(action)){	//add 2019/04/17 模糊查询
			String name = req.getParameter("name");
			List<Users> list = new ArrayList<Users>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findUser(name);
			s.setAttribute("userList", list);
			resp.sendRedirect("user_management.jsp");
		}if("deleteCheckUser".equals(action)){	//add 2019/04/17 批量刪除
			String[] arr1 = req.getParameterValues("arr");
			BackstageService backstageService = new BackstageServiceImpl();
			for(String a : arr1){
				String[] b = a.split(",");   //用","对数组a进行分割
				for(String c : b)
					backstageService.deleteUser(Integer.parseInt(c));
			}
			resp.sendRedirect("userManageServlet?action=findUser");
		}if("findPerson".equals(action)){
			int id = Integer.parseInt(req.getParameter("id").trim());
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			Users user = backstageService.findUserById(id);
			s.setAttribute("user", user);
			//resp.sendRedirect(req.getContextPath()+"user_management_update.jsp");
			resp.sendRedirect("person_management_update.jsp");
		}
	}
}
