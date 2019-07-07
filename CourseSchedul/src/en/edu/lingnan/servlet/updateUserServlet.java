package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.UserDto;

public class updateUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		System.out.println("hhhhhhhh");
		resp.setContentType("text/html;charset=GB2312");
		String cid=new String(req.getParameter("cid").getBytes("ISO-8859-1"));
		String pwd=new String(req.getParameter("cpwd").getBytes("ISO-8859-1"));	
		String cname=new String(req.getParameter("cname").getBytes("ISO-8859-1"));
		String csex=new String(req.getParameter("csex").getBytes("ISO-8859-1"));	
		String cauth=new String(req.getParameter("cauth").getBytes("ISO-8859-1"));
		String Uflag1=req.getParameter("Uflag");
		int Uflag = Integer.parseInt(Uflag1);
		Vector<UserDto> v = new Vector<UserDto> ();
		UserDao kd = new  UserDao();
		UserDto td = new  UserDto();
		td.setUserId(cid);
		td.setPassword(pwd);
		td.setUserName(cname);
		td.setUserSex(csex);
		td.setUserAuth(cauth);
		td.setUflag(Uflag);
		boolean flag =kd.UpdateUserInfo(td);
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=kd.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowAllUser.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
	

}
