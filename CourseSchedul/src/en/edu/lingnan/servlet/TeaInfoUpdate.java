package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.TeacherInformationDAO1;
import en.edu.lingnan.Dao.UserInformationDAO;
import en.edu.lingnan.Dto.UserInformationDTO;
import en.edu.lingnan.Dto.teacherInformationDTO;


public class TeaInfoUpdate extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String TeacherID=req.getParameter("TeacherID"); 
		String TeacherName=new String(req.getParameter("TeacherName").getBytes("ISO-8859-1"));
	 	String TeacherSex=new String(req.getParameter("TeacherSex").getBytes("ISO-8859-1"));
		String TeacherTel=req.getParameter("TeacherTel");
		String TeacherAge=req.getParameter("TeacherAge");
		String TeacherPwd=req.getParameter("TeacherPwd");
		
//		String MSflag=req.getParameter("MSflag");
//		String flag=req.getParameter("flag");
		System.out.println( 999+TeacherID+"   "+TeacherName+"   "+TeacherSex+"    "+TeacherTel+"   "+TeacherAge+"    "+TeacherPwd);
		teacherInformationDTO tdto = new teacherInformationDTO();
		UserInformationDTO udto = new UserInformationDTO();
		TeacherInformationDAO1 tdao = new TeacherInformationDAO1();
		UserInformationDAO udao = new UserInformationDAO();
		tdto.setTeacherID(TeacherID);
		tdto.setTeacherName(TeacherName);
		tdto.setTeacherSex(TeacherSex);
		tdto.setTeacherTel(TeacherTel);
		//整数要转换一下
		tdto.setTeacherAge(Integer.parseInt(TeacherAge));
		udto.setUserPsw(TeacherPwd);
		boolean flag1=tdao.updateTeachInfo(tdto);
		boolean flag2=udao.updateTeachInfo(udto);

		
		 //点击确认修改之后又回到展示所有用户信息的页面
		Vector <teacherInformationDTO> v = new Vector<teacherInformationDTO> ();
		Vector <UserInformationDTO> v1 = new Vector<UserInformationDTO> ();
		v=tdao.findAllTeachInfo();
		v1=udao.findAllUserInfo(); 
		HttpSession s = req.getSession();
		s.setAttribute("allTeacherInfo", v);
		s.setAttribute("allUserInfo", v1);
		resp.sendRedirect("TeaInfoUpdate.jsp?userid="+TeacherID);
	}

}
