package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassScheduleDAO;
import en.edu.lingnan.Dto.ClassScheduleDTO;

public class SelectClassScheduleServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassID = null;
		ClassID = req.getParameter("ClassID1");
		System.out.print(ClassID);
		ClassScheduleDAO d = new ClassScheduleDAO();
		HttpSession s = req.getSession();
		Vector<ClassScheduleDTO> v = new Vector<ClassScheduleDTO>();
		v = d.findClassScheduleInfoByClassID(ClassID);
		s.setAttribute("classSchedule", v);
		resp.sendRedirect("FindClassSchedule1.jsp");
	}
}
