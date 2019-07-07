package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.StudentDAO;
import en.edu.lingnan.Dto.StudentDTO;

public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、从页面获取我们想要的数据，有5个
		String StudentID=req.getParameter("StudentID");
		String StudentName=new String (req.getParameter("StudentName").getBytes("ISO-8859-1"));
		String StudentSex=new String (req.getParameter("StudentSex").getBytes("ISO-8859-1"));
		String ClassID=new String (req.getParameter("ClassID").getBytes("ISO-8859-1"));		
		String StudentAge=req.getParameter("StudentAge");
		System.out.println(StudentID+"    "+StudentName+"    "+StudentSex+"    "+ClassID+"    "+StudentAge);
		StudentDTO sdto=new StudentDTO();
		StudentDAO sdao=new StudentDAO();
		sdto.setStudentID(StudentID);
		sdto.setStudentName(StudentName);
		sdto.setStudentSex(StudentSex);
		sdto.setClassID(ClassID);
		sdto.setStudentAge(Integer.parseInt(StudentAge));
		//添加的时候根据StudentID来判断数据库中是否存在这个StudentID
		boolean flag = sdao.insertStudentInfo(sdto);
		System.out.println(flag);
		//3
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);
			Vector<StudentDTO> v=new Vector<StudentDTO>();
			v = sdao.findAllStudentInfo();			
			HttpSession s=req.getSession();
			s.setAttribute("allstudentinfo", v);
			resp.sendRedirect("showAllStudentInfo.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！请查看添加信息是否正确！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");

		}
	}

}
