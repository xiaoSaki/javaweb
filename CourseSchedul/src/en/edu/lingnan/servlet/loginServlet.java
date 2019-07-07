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


public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、从页面获取我们想要的数据
		String userid = req.getParameter("UserID");
		String password = req.getParameter("UserPsw");
		//2、调试后台业务逻辑去判断这个用户和密码是否存在且对于应
		UserDao a = new UserDao();
		String supervalue = a.LoginUserInfo(userid,password);
		HttpSession s = req.getSession();
		
		s.setAttribute("supervalue", supervalue);
		s.setAttribute("user", userid);
	    System.out.print("============"+supervalue);
		//3、根据结果去相应页面
	    if(supervalue == null)
		{
			JOptionPane.showMessageDialog(null, "你输入账号或密码有误，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}
		else if(supervalue != null)
		{
			
			s.setAttribute("password", password);
		    if(supervalue.trim().equals("1")||supervalue.trim().equals("2")||supervalue.trim().equals("3"))
		    {
			if(supervalue.trim().equals("1"))
			{
			resp.sendRedirect(req.getContextPath()+"/admin/index.jsp");
			}
			else {
//				UserDto td = new UserDto();
//				Vector<UserDto> v = new Vector<UserDto> ();
//				td.setUserId(user);
//				td.setPassword(password);
//				a.UpdateUserInfo(td);    //调用修改函数
//				//v=a.findalluserInfo();
//				v= a.finduserinfor(user, password);
//				HttpSession t = req.getSession();
//				t.setAttribute("pwd", v);
//				//resp.sendRedirect("updateUserpwd.jsp");
//			resp.sendRedirect(req.getContextPath()+"/person_mian.html");
				if(supervalue.trim().equals("2"))
				{
					resp.sendRedirect(req.getContextPath()+"/teacher/ok.jsp?userid="+userid+"");
				}
				else if(supervalue.trim().equals("3"))
				{					
					resp.sendRedirect(req.getContextPath()+"/student/student.jsp?userid="+userid+"");
				}
			}
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		}
		
	}
		
}