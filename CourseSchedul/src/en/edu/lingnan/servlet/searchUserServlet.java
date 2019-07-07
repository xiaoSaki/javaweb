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

public class searchUserServlet extends HttpServlet {
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
	resp.sendRedirect("SearchUserById.jsp");  //执行完后跳转页面
	}
}
