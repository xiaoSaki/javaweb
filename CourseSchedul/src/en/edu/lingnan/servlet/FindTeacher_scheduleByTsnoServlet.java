package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.Teacher_scheduleDAO;
import en.edu.lingnan.Dto.Teacher_scheduleDTO;

public class FindTeacher_scheduleByTsnoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO>();
		Teacher_scheduleDAO tdao = new  Teacher_scheduleDAO();
		String Tsno = null;
		Tsno=req.getParameter("Tsno");
		System.out.print("000------"+Tsno);
		v = tdao.findTeacher_scheduleInfoByTsno(Tsno);
		HttpSession s = req.getSession();
		s.setAttribute("allTeacher_scheduleInfo", v);
		resp.sendRedirect("ShowallTeacher_scheduleInfoById.jsp");  //执行完后跳转页面
	}

}
