package en.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.StudentDAO;
import en.edu.lingnan.Dto.StudentDTO;

public class SearchStudentInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO sd = new StudentDAO();
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		String StudentID=req.getParameter("StudentID");	
		v = sd.findStudentInfoById(StudentID);
		HttpSession s=req.getSession();
		s.setAttribute("allstudentinfobyid", v);
		resp.sendRedirect("SearchStudentInformationById.jsp");
	}

}
