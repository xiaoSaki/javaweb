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

public class FindClassScheduleServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<ClassScheduleDTO> v = new Vector<ClassScheduleDTO>();
		ClassScheduleDAO d = new ClassScheduleDAO();
		v = d.findAllClassScheduleInfo();
		HttpSession s = req.getSession();
		s.setAttribute("classSchedule", v);
		resp.sendRedirect("FindClassSchedule1.jsp");
	}
}
