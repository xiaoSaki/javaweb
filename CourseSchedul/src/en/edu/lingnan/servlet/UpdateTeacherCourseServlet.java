package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.teacherCourseDAO;
import en.edu.lingnan.Dto.teacherCourseDTO;
public class UpdateTeacherCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherCourseID = req.getParameter("TeacherCourseID");
		TeacherCourseID = new String(TeacherCourseID.getBytes("iso8859-1"),"GB2312");
		String TeacherID = req.getParameter("TeacherID");
		TeacherID = new String(TeacherID.getBytes("iso8859-1"),"GB2312");
		String CourseID = req.getParameter("CourseID");
		CourseID = new String(CourseID.getBytes("iso8859-1"),"GB2312");
		String ClassID = req.getParameter("ClassID");
		ClassID = new String(ClassID.getBytes("iso8859-1"),"GB2312");
		String WeekDay = req.getParameter("WeekDay");
		WeekDay = new String(WeekDay.getBytes("iso8859-1"),"GB2312");
		String ClassTime = req.getParameter("ClassTime");
		ClassTime = new String(ClassTime.getBytes("iso8859-1"),"GB2312");
		String ClassroomID = req.getParameter("ClassroomID");
		ClassroomID = new String(ClassroomID.getBytes("iso8859-1"),"GB2312");
		String TCflag = req.getParameter("TCflag");
		TCflag = new String(TCflag.getBytes("iso8859-1"),"GB2312");
		System.out.println(TeacherCourseID+"    "+TeacherID);
		
		teacherCourseDTO sdto = new teacherCourseDTO();
		teacherCourseDAO sdao = new teacherCourseDAO();
		sdto.setTeacherCourseID(TeacherCourseID);
		sdto.setTeacherID(TeacherID);
		sdto.setCourseID(CourseID);
		sdto.setClassID(ClassID);
		sdto.setWeekDay(WeekDay);
		sdto.setClassTime(ClassTime);
		sdto.setClassroomID(ClassroomID);
		sdto.setTCflag(Integer.parseInt(TCflag));
		boolean flag = sdao.updateTeacherCourse(sdto);
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		if (flag) {
			
			JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v = sdao.findTeacherCourse();
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("showTeacherCourse.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，修改信息有误！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
	
}
