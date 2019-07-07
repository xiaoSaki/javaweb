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
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.StudentDTO;
import en.edu.lingnan.Dto.UserDto;



public class UpdateInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentID=req.getParameter("StudentID"); 
		String StudentName=new String(req.getParameter("StudentName").getBytes("ISO-8859-1"));
	 	String StudentSex=new String(req.getParameter("StudentSex").getBytes("ISO-8859-1"));
		String ClassID=new String(req.getParameter("ClassID").getBytes("ISO-8859-1"));
		String StudentAge=req.getParameter("StudentAge");
		String Password=req.getParameter("UserPsw");
		
//		String MSflag=req.getParameter("MSflag");
//		String flag=req.getParameter("flag");
		System.out.println( 999+StudentID+"   "+StudentName+"   "+StudentSex+"    "+ClassID+"   "+StudentAge+"    "+Password);
		StudentDTO sdto = new StudentDTO();
		UserDto udto = new UserDto();
		StudentDAO sdao = new StudentDAO();
		UserDao udao = new UserDao();
		sdto.setStudentID(StudentID);
		sdto.setStudentName(StudentName);
		sdto.setStudentSex(StudentSex);
		sdto.setClassID(ClassID);
		//整数要转换一下
		sdto.setStudentAge(Integer.parseInt(StudentAge));
		udto.setPassword(Password);
		boolean flag1=sdao.updateStudentInfo(sdto);
		boolean flag2=udao.UpdateUserInfo(udto);

		if(flag2||flag1)
		{
			JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		
		 //点击确认修改之后又回到展示所有用户信息的页面
		Vector <StudentDTO> v = new Vector<StudentDTO> ();
		Vector <UserDto> v1 = new Vector<UserDto> ();
		v=sdao.findAllStudentInfo();
		v1=udao.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allstudentInfo", v);
		s.setAttribute("allUserInfo", v1);
		resp.sendRedirect("changInformation.jsp?UserID="+StudentID);
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}

}
