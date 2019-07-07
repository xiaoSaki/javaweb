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
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.Dto.UserDto;

public class deleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sid = null; 
		sid = req.getParameter("sid");
		Vector<StudentDto> v = new Vector<StudentDto> ();
		StudentDao sd = new  StudentDao();
		boolean flag = sd.deleteStudentid(sid);
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
			v=sd.findallStudentInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allstudent", v);
			resp.sendRedirect("ShowAllStudent.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
		
	}


}
