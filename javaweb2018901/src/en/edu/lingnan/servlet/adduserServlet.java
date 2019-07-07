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

public class adduserServlet extends HttpServlet {
public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String user = null;
		String password = null;
		String id = null;
		String superuser = null;
	    id = new String(req.getParameter("Aid").getBytes("ISO-8859-1"),"UTF-8");
	    user = new String(req.getParameter("Auser").getBytes("ISO-8859-1"),"UTF-8");
	    password = new String(req.getParameter("Apassword").getBytes("ISO-8859-1"),"UTF-8");
	    superuser = new String(req.getParameter("Asuperuser").getBytes("ISO-8859-1"),"UTF-8");
		//2
		UserDao a = new UserDao();
		UserDto adto = new UserDto();
		adto.setAid(id);
		adto.setAuser(user);
		adto.setApassword(password);
		adto.setAsuperuser(superuser);
		boolean flag = a.addUserInfo(adto);
		System.out.println(flag);
		//3
		if(flag)
		{
			Vector<UserDto> v = new Vector<UserDto>();
		    UserDao ad = new  UserDao();
			v = ad.findalluserInfo();
			HttpSession s = req.getSession();
			s.setAttribute("alluser", v);
			resp.sendRedirect("ShowAlluser.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/admin/adduser_info.html");

		}
	}


}
