package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.StudentDAO;
import en.edu.lingnan.Dto.StudentDTO;


public class SearchAllStuInfo extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("11111111");
		StudentDAO sdao = new StudentDAO();
		
//		String userid=req.getParameter("userid");
//		System.out.println("yyy"+userid);
		HttpSession s = req.getSession();
//		s.setAttribute("userid", userid);
		
		Vector <StudentDTO> v = new Vector<StudentDTO> ();
		v=sdao.findAllStudentInfo();
		s.setAttribute("allStuInfo", v);
		resp.sendRedirect("showAllStuInfo.jsp");
	}


}
