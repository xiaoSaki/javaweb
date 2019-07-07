package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.Teacher_scheduleDAO;
import en.edu.lingnan.Dao.teacherCourseDAO;
import en.edu.lingnan.Dto.Teacher_scheduleDTO;
import en.edu.lingnan.Dto.teacherCourseDTO;

public class SelectProcedure3Servlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherName = req.getParameter("TeacherName");
		TeacherName = new String(TeacherName.getBytes("iso8859-1"), "gb2312");// 用于解决数据传输过程中带来的乱码		
		teacherCourseDAO sd = new teacherCourseDAO();
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		v = sd.findTeacherCourseByTname(TeacherName);
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser1", v);
		resp.sendRedirect("Procedure3.jsp");
	}
}
