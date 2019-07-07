package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.Dto.UserDto;

public class DeleteStucheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String[] arr = req.getParameterValues("arr");
	StudentDao sdao = new StudentDao();
	for(String a : arr){
		String[] b = a.split(",");
	for(String c : b)
		sdao.deleteStudentid(c);
}
	Vector<StudentDto> v = new Vector<StudentDto> ();
	v=sdao.findallStudentInfo();
	HttpSession s = req.getSession();
	s.setAttribute("allstudent", v);
	resp.sendRedirect("ShowAllStudent.jsp");
}

}
