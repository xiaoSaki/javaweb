package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.UserDto;

public class findAllUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<UserDto> v = new Vector<UserDto>();
		UserDao ad = new  UserDao();
		v = ad.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowAllUser.jsp");  //执行完后跳转页面
		
	}

}
