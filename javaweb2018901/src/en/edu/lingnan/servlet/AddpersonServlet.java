package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.Dto.UserDto;

public class AddpersonServlet extends HttpServlet {
public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		HttpSession s = req.getSession();
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String sid=req.getParameter("Sid");
		String sex = new String(req.getParameter("Ssex").getBytes("ISO-8859-1"));
		String classid = new String(req.getParameter("Sclassid").getBytes("ISO-8859-1"));
		String sage = req.getParameter("Sage");
		String sname = new String(req.getParameter("Sname").getBytes("ISO-8859-1"));
		String dep = new String(req.getParameter("Sdepartment").getBytes("ISO-8859-1"));
		//2
		Vector<StudentDto> v = new Vector<StudentDto> ();
		StudentDao ad = new  StudentDao();
		StudentDto td = new  StudentDto();
		//System.out.println("======-----==="+sid);
		td.setSid(sid);
		td.setStudentdep(dep);
		td.setStudentclass(classid);
		td.setStudentname(sname);
		td.setStudentsex(sex);
		td.setStudentage(sage);
		s.getAttribute("user");
	    boolean flag = ad.addStudentInfo(td); //调用修改函数
	    if(flag)
	    {
			resp.sendRedirect(req.getContextPath()+"/index.html");
	    	System.out.print("-------------------------kkkk");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "注册完善信息失败！", "提示", JOptionPane.ERROR_MESSAGE);
	    	//resp.sendRedirect(req.getContextPath()+"/updateperson.html");
	    	resp.sendRedirect("updatePerson.jsp");
	    	System.out.print("-------------------------kkkk00000000000000");	
		}
		
	}




}
