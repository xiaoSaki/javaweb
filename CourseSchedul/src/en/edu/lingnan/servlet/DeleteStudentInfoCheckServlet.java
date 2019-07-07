package en.edu.lingnan.servlet;
import en.edu.lingnan.Dao.ClassScheduleDAO;
import en.edu.lingnan.Dao.StudentDAO;
import en.edu.lingnan.Dto.ClassScheduleDTO;
import en.edu.lingnan.Dto.StudentDTO;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteStudentInfoCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr= req.getParameterValues("arr");
		StudentDAO stu =new StudentDAO();
		for(String a : arr){
			String[] b=a.split(",");
			for(String c : b)
				stu.deleteStudentByStudentID(c);
			
			Vector<StudentDTO> v=new Vector<StudentDTO>();
			v = stu.findAllStudentInfo();
			HttpSession s=req.getSession();
			s.setAttribute("allstudentinfo", v);
			resp.sendRedirect("showAllStudentInfo.jsp");
		}
	}

}
