package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.Teacher_scheduleDAO;
import en.edu.lingnan.Dto.Teacher_scheduleDTO;


public class SearchTeacher_scheduleInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO>();
		Teacher_scheduleDAO tsdo = new  Teacher_scheduleDAO();
		String TeacherID = null;
		TeacherID=req.getParameter("TeacherID");
		System.out.print("000kkk------"+TeacherID);
		v = tsdo.findTeacher_scheduleInfoById(TeacherID);
		HttpSession s = req.getSession();
		s.setAttribute("allTeacher_scheduleInfo", v);
		resp.sendRedirect("SearchTeacher_scheduleById.jsp");  //执行完后跳转页面
	}

}
