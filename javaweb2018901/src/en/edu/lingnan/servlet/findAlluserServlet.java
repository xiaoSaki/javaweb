package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.UserDao;

import en.edu.lingnan.Dto.UserDto;

public class findAlluserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<UserDto> v = new Vector<UserDto>();
	    UserDao ad = new  UserDao();
		v = ad.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);  
		resp.sendRedirect("ShowAlluser.jsp");  //执行完后跳转页面
		
	}

}

