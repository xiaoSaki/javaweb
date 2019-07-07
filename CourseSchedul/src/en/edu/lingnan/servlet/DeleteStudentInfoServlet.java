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



public class DeleteStudentInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("22lllllllllllllll");
		String StudentID=req.getParameter("StudentID");
		//System.out.println("aaaaa:     "+StudentID);
		StudentDAO sd = new StudentDAO();
		boolean flag= sd.deleteStudentByStudentID(StudentID);
		
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		v = sd.findAllStudentInfo();
		HttpSession s=req.getSession();
		s.setAttribute("allstudentinfo", v);
		resp.sendRedirect("ShowAllStudentInfo.jsp");
	}

}
