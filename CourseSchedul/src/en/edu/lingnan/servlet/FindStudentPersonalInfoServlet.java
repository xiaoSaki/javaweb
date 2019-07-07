package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.StudentDAO;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDTO;
import en.edu.lingnan.Dto.UserDto;


public class FindStudentPersonalInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<UserDto> v=new Vector<UserDto>();
		UserDao sd = new UserDao();
		String StudentID=req.getParameter("user");	
		System.out.print("000------"+StudentID);
		v = sd.finduserInfoByid(StudentID);
		HttpSession s=req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowUserById.jsp");
	}

}
