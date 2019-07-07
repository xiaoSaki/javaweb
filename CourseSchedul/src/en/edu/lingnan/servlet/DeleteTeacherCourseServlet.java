package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.teacherCourseDAO;
import en.edu.lingnan.Dto.teacherCourseDTO;
public class DeleteTeacherCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherCourseID = req.getParameter("TeacherCourseID");	
		int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认对话框", JOptionPane.YES_NO_OPTION);   
		if (n == JOptionPane.YES_OPTION) { 
			teacherCourseDAO sd = new teacherCourseDAO();
			boolean flag = sd.deleteTeacherCourseByID(TeacherCourseID);
			Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
			v = sd.findTeacherCourse();
			HttpSession s = req.getSession();
			s.setAttribute("TeacherUser", v);
		    JOptionPane.showMessageDialog(new JFrame(),"已删除");  
		} else if (n == JOptionPane.NO_OPTION) {   
		    JOptionPane.showMessageDialog(new JFrame(),"已取消");  
		}  		
		resp.sendRedirect("showTeacherCourse.jsp");
	}
	
}
