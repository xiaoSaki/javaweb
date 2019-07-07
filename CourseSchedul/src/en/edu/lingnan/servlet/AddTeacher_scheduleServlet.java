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


public class AddTeacher_scheduleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String Tsno = null;
		String TeacherID = null;
		String CourseID = null;

		Tsno = new String(req.getParameter("Tsno").getBytes("ISO-8859-1"),"UTF-8");
		TeacherID = new String(req.getParameter("TeacherID").getBytes("ISO-8859-1"),"UTF-8");
		CourseID = new String(req.getParameter("CourseID").getBytes("ISO-8859-1"),"UTF-8");
		//2
		Teacher_scheduleDAO tdao = new Teacher_scheduleDAO();
		Teacher_scheduleDTO tdto = new Teacher_scheduleDTO();
		tdto.setTsno(Tsno);
		tdto.setTeacherID(TeacherID);
		tdto.setCourseID(CourseID);
		boolean flag = tdao.insertTeacher_scheduleInfo(tdto);
		System.out.println(flag);
		//3
		if(flag)
		{
			Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO>();
			Teacher_scheduleDAO tao = new  Teacher_scheduleDAO();
			v = tao.findTeacher_scheduleInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allTeacher_scheduleInfo", v);
			resp.sendRedirect("showAllTeacher_scheduleInfo.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/admin/addTeacher_schedule.jsp");

		}
	}

}
