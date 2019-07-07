package en.edu.lingnan.servlet;

import java.io.IOException;
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


public class UpdateStudentInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentID=req.getParameter("StudentID");
		String StudentName=new String (req.getParameter("StudentName").getBytes("ISO-8859-1"));
		String StudentSex=new String (req.getParameter("StudentSex").getBytes("ISO-8859-1"));
		String ClassID=new String (req.getParameter("ClassID").getBytes("ISO-8859-1"));		
		String StudentAge1=req.getParameter("StudentAge");  
		int StudentAge = Integer.parseInt(StudentAge1);
		String SIflag1=req.getParameter("SIflag");  
		int SIflag = Integer.parseInt(SIflag1);
		System.out.println(StudentID+"    "+StudentName+"    "+StudentSex+"    "+ClassID+"    "+StudentAge);
		StudentDTO sdto=new StudentDTO();
		StudentDAO sdao=new StudentDAO();
		sdto.setStudentID(StudentID);
		sdto.setStudentName(StudentName);
		sdto.setStudentSex(StudentSex);
		sdto.setClassID(ClassID);
		sdto.setStudentAge(StudentAge);
		sdto.setSIflag(SIflag);
		boolean flag=sdao.updateStudentInfo(sdto);
		//修改成功后再次更新一下页面
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		v = sdao.findAllStudentInfo();
		HttpSession s=req.getSession();
		s.setAttribute("allstudentinfo", v);
		resp.sendRedirect("ShowAllStudentInfo.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}

}
