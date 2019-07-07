package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.UserDto;

public class finduserByIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<UserDto> v = new Vector<UserDto>();
		UserDao ad = new  UserDao();
		String aid=null;
		aid=req.getParameter("Aid");
		System.out.println("-------------------------+++"+aid);
		v = ad.finduserInfoByid(aid);
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowuserByid.jsp");  //执行完后跳转页面
		
	}

}
