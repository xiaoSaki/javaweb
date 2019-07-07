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

public class AddstudentServlet extends HttpServlet {
public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String sid=req.getParameter("Sid");
		String sex = new String(req.getParameter("Ssex").getBytes("ISO-8859-1"),"UTF-8");
		String classid = new String(req.getParameter("Sclassid").getBytes("ISO-8859-1"),"UTF-8");
		String sage = req.getParameter("Sage");
		String sname = new String(req.getParameter("Sname").getBytes("ISO-8859-1"),"UTF-8");
		String dep = new String(req.getParameter("Sdepartment").getBytes("ISO-8859-1"),"UTF-8");
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
	    boolean flag = ad.addStudentInfo(td); //调用修改函数
	    if(flag)
	    {
			StudentDao sdao = new  StudentDao();
			v = sdao.findallStudentInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allstudent", v);
			resp.sendRedirect("ShowAllStudent.jsp");
	    	System.out.print("-------------------------kkkk");
	    }
	    else {
	    	if(!(sid==""||dep==""||classid==""||sex==""||sage==""||sname==""))
	    	{
	    		JOptionPane.showMessageDialog(null, "该用户不存在", "提示", JOptionPane.ERROR_MESSAGE);
	    	}
	    	//JOptionPane.showMessageDialog(null, "提示", "该用户不存在", JOptionPane.ERROR_MESSAGE);
	    	resp.sendRedirect(req.getContextPath()+"/admin/addstudent.html");
	    	System.out.print("-------------------------kkkk00000000000000");
		}
		
	}



}
