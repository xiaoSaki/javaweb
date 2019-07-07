package en.edu.lingnan.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dto.StudentDto;
public class findAllStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<StudentDto> v = new Vector<StudentDto>();
		StudentDao sdao = new  StudentDao();
		v = sdao.findallStudentInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allstudent", v);
		resp.sendRedirect("ShowAllStudent.jsp");  //执行完后跳转页面
		
		
	}
}
