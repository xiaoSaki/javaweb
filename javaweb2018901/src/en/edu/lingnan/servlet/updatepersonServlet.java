package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dto.StudentDto;

public class updatepersonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String sid=new String(req.getParameter("Sid").getBytes("ISO-8859-1"));
		String sex = new String(req.getParameter("Ssex").getBytes("ISO-8859-1"));
		String classid = new String(req.getParameter("Sclassid").getBytes("ISO-8859-1"));
		String sage = req.getParameter("Sage");
		String sname = new String(req.getParameter("Sname").getBytes("ISO-8859-1"));
		String dep = new String(req.getParameter("Sdepartment").getBytes("ISO-8859-1"));
		System.out.println("++++++++++"+sname);
		Vector<StudentDto> v = new Vector<StudentDto> ();
		StudentDao ad = new  StudentDao();
		StudentDto td = new  StudentDto();
		td.setSid(sid);
		//System.out.println("======-----==="+sid);
		td.setSid(sid);
		td.setStudentdep(dep);
		td.setStudentclass(classid);
		td.setStudentname(sname);
		td.setStudentsex(sex);
		td.setStudentage(sage);
		ad.UndateStudentInfo(td);  //调用修改函数
		v=ad.findallStudentInfo();
		HttpSession s = req.getSession();
		//s.setAttribute("sid", sid);
		s.setAttribute("allperson", v);
		resp.sendRedirect(req.getContextPath()+"/person_mian.html");
		
	}
}
