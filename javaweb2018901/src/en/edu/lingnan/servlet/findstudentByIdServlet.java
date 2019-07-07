package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

	import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.Dto.UserDto;
public class findstudentByIdServlet extends HttpServlet {
		protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
				throws ServletException ,java.io.IOException {
		Vector<StudentDto> v = new Vector<StudentDto>();
		StudentDao ad = new  StudentDao();
		StudentDto td = new  StudentDto();
		String sid = null;
		sid=req.getParameter("Sid");
		v = ad.findStudentByid(sid);
		//v=ad.findStudentByone(sid);
		HttpSession s = req.getSession();
		s.setAttribute("allstudent", v);
		resp.sendRedirect("ShowStudentByid.jsp");  //执行完后跳转页面
		
	}

	}

