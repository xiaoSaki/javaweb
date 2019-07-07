package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.UserDto;

public class findUserByidServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException ,java.io.IOException {
	Vector<UserDto> v = new Vector<UserDto>();
	UserDao ad = new  UserDao();
	String cid = null;
	cid=req.getParameter("Cid");
	System.out.print("000------"+cid);
	v = ad.finduserInfoByid(cid);
	HttpSession s = req.getSession();
	s.setAttribute("alluser", v);
	resp.sendRedirect("ShowUserById.jsp");  //执行完后跳转页面
	}

}
