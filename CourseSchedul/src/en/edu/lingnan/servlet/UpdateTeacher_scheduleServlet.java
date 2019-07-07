package en.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.Teacher_scheduleDAO;
import en.edu.lingnan.Dto.Teacher_scheduleDTO;


public class UpdateTeacher_scheduleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GB2312");
		System.out.println("hhhhhhhh");
		resp.setContentType("text/html;charset=GB2312");
		String Tsno=new String(req.getParameter("Tsno").getBytes("ISO-8859-1"));
		String TeacherID=new String(req.getParameter("TeacherID").getBytes("ISO-8859-1"));	
		String CourseID=new String(req.getParameter("CourseID").getBytes("ISO-8859-1"));
		Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO> ();
		Teacher_scheduleDAO tdao = new  Teacher_scheduleDAO();
		Teacher_scheduleDTO tdto = new  Teacher_scheduleDTO();
		tdto.setTsno(Tsno);
		tdto.setTeacherID(TeacherID);
		tdto.setCourseID(CourseID);
		boolean flag= tdao.updateTeacher_scheduleInfo(tdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=tdao.findTeacher_scheduleInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allTeacher_scheduleInfo", v);
		resp.sendRedirect("showAllTeacher_scheduleInfo.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}

}
