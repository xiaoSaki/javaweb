package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dto.StudentDto;

public class FindUserIdServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException ,java.io.IOException {
	Vector<StudentDto> v = new Vector<StudentDto>();
//	StudentDao ad = new  StudentDao();
//	StudentDto td = new  StudentDto();
	HttpSession s = req.getSession();
	String sid = null;
	v=(Vector<StudentDto>) s.getAttribute("person");
//	sid=req.getParameter("Sid");
//	v = ad.findStudentByid(sid);
//	
	s.setAttribute("studentperson", v);
	resp.sendRedirect("ShowStudentperson.jsp");  //执行完后跳转页面
	
}


}
