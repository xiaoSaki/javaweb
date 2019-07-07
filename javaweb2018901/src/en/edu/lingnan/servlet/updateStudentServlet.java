package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.Dto.UserDto;

public class updateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String sid=new String(req.getParameter("sid").getBytes("ISO-8859-1"));
		String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"));
		String classid = new String(req.getParameter("classid").getBytes("ISO-8859-1"));
		String sage = req.getParameter("sage");
		String sname = new String(req.getParameter("sname").getBytes("ISO-8859-1"));
		String dep = new String(req.getParameter("dep").getBytes("ISO-8859-1"));
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
		boolean flag=ad.UndateStudentInfo(td);  //调用修改函数
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		v=ad.findallStudentInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allstudent", v);
		resp.sendRedirect("ShowAllStudent.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
		
	}

}
