package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.business.service.AnswerService;
import com.lingnan.examsys.business.service.AnswerServiceImpl;
import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "用户登录接口：根据用户权值转跳到对应客户端", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernam_str = request.getParameter("username");
		int username = 0;
		if(usernam_str != null & !usernam_str.equals("")) {
			username = Integer.parseInt(usernam_str);
		}
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserService user_serv = UserServiceImpl.getInstance();
		AnswerService ans_serv = AnswerServiceImpl.getInstance();
		
		UserVO user_vo = user_serv.login(username, password);
		int supervalue = 0;
		if(user_vo != null)
			supervalue = user_vo.getSupervalue();
		switch (supervalue) {
		case 1:
			if(new Timestamp(System.currentTimeMillis()).before(user_vo.getBlocked_time())) {
				request.setAttribute("lock_status", 1);
				request.setAttribute("unlock_time", user_vo.getBlocked_time());
				session.setAttribute("realname", user_vo.getUser_name());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}else {
				session.setAttribute("lock_status", 0);
				session.setAttribute("supervalue", 1);
				session.setAttribute("user_id", user_vo.getUser_id());
				session.setAttribute("realname", user_vo.getUser_name());
				int ans_id_exist = ans_serv.ifExistAnswering(username);											//检测是否有未完成答题
				if(ans_id_exist != 0) {
					session.setAttribute("answer_status", 1);
					session.setAttribute("ans_id", ans_id_exist);
				}else {
					session.setAttribute("answer_status", 0);
					session.setAttribute("ans_id", 0);
				}
				response.sendRedirect("students/StudentIndex.jsp");
				//request.getRequestDispatcher("students/StudentIndex.jsp").forward(request, response);
			}
			break;
		case 2:
			session.setAttribute("supervalue", supervalue);
	        UserVO user=new UserVO();
	        System.out.println(user_vo.getUser_id()+"  "+password);
	        user.setUser_id(user_vo.getUser_id());
	        user.setUser_pwd(password);;
			UserService UserService = new UserServiceImpl();
			List<UserVO> UserList = UserService.findUserByIdAndPassword(user);
			session.setAttribute("UserList",UserList);
			response.sendRedirect("teachers/manage_students.jsp");
			break;
		case 3:
			session.setAttribute("supervalue", supervalue);
			session.setAttribute("user_id", user_vo.getUser_id());
			session.setAttribute("realname", user_vo.getUser_name());
			response.sendRedirect("admins/AdminIndex.jsp");
			break;
		default:
			request.setAttribute("supervalue", 0);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
