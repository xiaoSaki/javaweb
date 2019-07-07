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
public class SelectTeacherCourse extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherCourseID = req.getParameter("TeacherCourseID");
		TeacherCourseID = new String(TeacherCourseID.getBytes("iso8859-1"), "gb2312");// 用于解决数据传输过程中带来的乱码		
		teacherCourseDAO sd = new teacherCourseDAO();
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		v = sd.findTeacherCourseByID(TeacherCourseID);
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("selectTeacherCourse.jsp");
	}
	
}
