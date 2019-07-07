package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.Teacher_scheduleDAO;
import en.edu.lingnan.Dto.Teacher_scheduleDTO;


public class DeleteTeacher_scheduleInfoByTsnoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 String Tsno = null;
		 Tsno = req.getParameter("Tsno");
		Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO> ();
		Teacher_scheduleDAO tsdo = new Teacher_scheduleDAO();
		boolean flag =tsdo.deleteTeacher_scheduleByTsno(Tsno);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=tsdo.findTeacher_scheduleInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allTeacher_scheduleInfo", v);
		resp.sendRedirect("showAllTeacher_scheduleInfo.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin.html");
		}
	}

}
