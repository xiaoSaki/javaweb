package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.teacherCourseDAO;
import en.edu.lingnan.Dto.teacherCourseDTO;

public class Procedure1 extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		teacherCourseDAO sd = new teacherCourseDAO();
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		v = sd.findTeacherCourse();
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser2", v);
		resp.sendRedirect("Procedure1.jsp");
	}
}
