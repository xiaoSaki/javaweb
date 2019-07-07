package en.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.UserDto;

public class AddUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String Name = null;
		String password = null;
		String id = null;
		String superuser = null;
		String sex = null;
	    id = new String(req.getParameter("userId").getBytes("ISO-8859-1"),"UTF-8");
	    Name = new String(req.getParameter("userName").getBytes("ISO-8859-1"),"UTF-8");
	    sex = new String(req.getParameter("csex").getBytes("ISO-8859-1"),"UTF-8");
	    password = new String(req.getParameter("userpassword").getBytes("ISO-8859-1"),"UTF-8");
	    superuser = new String(req.getParameter("cauth").getBytes("ISO-8859-1"),"UTF-8");
		//2
		UserDao a = new UserDao();
		UserDto adto = new UserDto();
		adto.setUserId(id);
		adto.setPassword(password);
		adto.setUserName(Name);
		adto.setUserSex(sex);
		adto.setUserAuth(superuser);
		boolean flag = a.addUserInfo(adto);
		System.out.println(flag);
		//3
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
			Vector<UserDto> v = new Vector<UserDto>();
		    UserDao ad = new  UserDao();
			v = ad.findalluserInfo();
			HttpSession s = req.getSession();
			s.setAttribute("alluser", v);
			resp.sendRedirect("ShowAllUser.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");

		}
	}


}
