package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.teacherInformationDAO;
import en.edu.lingnan.Dto.teacherInformationDTO;
public class DeleteTeacherInfoCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String[] arr = req.getParameterValues("arr");
		teacherInformationDAO stu = new teacherInformationDAO();
		for(String a : arr){
			String[] b = a.split(",");
			for(String c : b )
				stu.deleteTeacherInformationByID(c);			
		}
		Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
		v = stu.findTeacherInformation();
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("showTeacherInformation.jsp");
	}
	
}
