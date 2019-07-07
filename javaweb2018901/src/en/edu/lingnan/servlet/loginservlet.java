
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


public class loginservlet extends HttpServlet {
	public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、从页面获取我们想要的数据
		Vector<UserDto> v1 = new Vector<UserDto> ();
		String user = null;
		String password = null;
		user = req.getParameter("Auser");
		password = req.getParameter("Apassword");
		//2、调试后台业务逻辑去判断这个用户和密码是否存在且对于应
		UserDao a = new UserDao();
		String supervalue = a.LoginUserInfo(user,password);
		HttpSession s = req.getSession();
		v1 = a.finduserinfor(user,password);
		s.setAttribute("userinfo",v1 );
		s.setAttribute("supervalue", supervalue);
	    System.out.print(supervalue);
	    
		//3、根据结果去相应页面
		if(supervalue == null)
		{
			JOptionPane.showMessageDialog(null, "你输入账号或密码有误，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}
		else if(supervalue != null)
		{
			s.setAttribute("user", user);
			
			s.setAttribute("password", password);
		    if(supervalue.equals("1")||supervalue.equals("2")){
			if(supervalue.equals("1"))
			{
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
			}
			else {
				UserDto td = new UserDto();
				Vector<UserDto> v = new Vector<UserDto> ();
				td.setAuser(user);
				td.setApassword(password);
			    //td.setAsuperuser(password);
				a.UpdateUserInfo(td);    //调用修改函数
				//v=a.findalluserInfo();
				v= a.finduserinfor(user, password);
				HttpSession t = req.getSession();
				t.setAttribute("pwd", v);
				//resp.sendRedirect("updateUserpwd.jsp");
			resp.sendRedirect(req.getContextPath()+"/person_mian.html");
			}
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		}
		
		
	}
		
}