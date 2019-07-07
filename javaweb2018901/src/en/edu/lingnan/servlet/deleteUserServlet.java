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

public class deleteUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String aid = null; 
		aid = req.getParameter("aid");
		Vector<UserDto> v = new Vector<UserDto> ();
		UserDao ad = new  UserDao();
		boolean flag =ad.deleteUsersid(aid);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=ad.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowAlluser.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
		
	}

}
