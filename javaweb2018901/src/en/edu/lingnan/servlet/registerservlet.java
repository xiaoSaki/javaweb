package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.UserDto;

public class registerservlet extends HttpServlet{
public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDao a = new UserDao();
		UserDto adto = new UserDto();
		//1
		String user = null;
		String password = null;
		String id = null;
		String superuser = "2";
		id = new String(req.getParameter("Aid").getBytes("ISO-8859-1"));
		System.out.println("-------------------------+++"+id);
		user = new String(req.getParameter("Auser").getBytes("ISO-8859-1"));
		password = new String(req.getParameter("Apassword").getBytes("ISO-8859-1"));
		String regpwd = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		if(!(password.matches(regpwd)))
		{
			JOptionPane.showMessageDialog(null, "你输入的密码不合法，请输入长度为6至16的字母与数字组合！！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/regiter.html");
		}
		else {
				
		if((a.ifusein(user, superuser))||(a.finduserId_in(id)))
		{
			JOptionPane.showMessageDialog(null, "你注册的账号已存在，请重新注册！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/regiter.html");
		}
		//2
		else {
		adto.setAid(id);
		adto.setAuser(user);
		adto.setApassword(password);
		adto.setAsuperuser(superuser);
		boolean flag = a.addUserInfo(adto);
		
		//System.out.println(flag);
		//3
		if(flag)
		{
			HttpSession s = req.getSession();
			UserDao sdao = new  UserDao();
			Vector<UserDto> v = new Vector<UserDto> ();
			v= sdao.finduserInfoByid(id);
			//v = sdao.findallStudentInfo();
			s.setAttribute("user", v);
			//resp.sendRedirect(req.getContextPath()+"/updateperson.html");
			resp.sendRedirect("updatePerson.jsp");
			//resp.sendRedirect(req.getContextPath()+"/index.html");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/regiter.html");

		}
		}
		}
	}

}
