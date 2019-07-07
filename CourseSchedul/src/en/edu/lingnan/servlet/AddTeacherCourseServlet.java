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


public class AddTeacherCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherCourseID = req.getParameter("TeacherCourseID");
		TeacherCourseID = new String(TeacherCourseID.getBytes("iso8859-1"), "gb2312");// 用于解决数据传输过程中带来的乱码
		String TeacherID = req.getParameter("TeacherID");
		TeacherID = new String(TeacherID.getBytes("iso8859-1"), "gb2312");
		String CourseID = req.getParameter("CourseID");
		CourseID = new String(CourseID.getBytes("iso8859-1"), "gb2312");
		String ClassID = req.getParameter("ClassID");
		ClassID = new String(ClassID.getBytes("iso8859-1"), "gb2312");
		String WeekDay = req.getParameter("WeekDay");
		WeekDay = new String(WeekDay.getBytes("iso8859-1"), "gb2312");
		String ClassTime = req.getParameter("ClassTime");
		ClassTime = new String(ClassTime.getBytes("iso8859-1"), "gb2312");
		String ClassroomID = req.getParameter("ClassroomID");
		ClassroomID = new String(ClassroomID.getBytes("iso8859-1"), "gb2312");
		String TCflag = req.getParameter("TCflag");
		TCflag = new String(TCflag.getBytes("iso8859-1"), "gb2312");
		System.out.println(TeacherCourseID+"    "+TeacherID+"    "+CourseID+"    "+ClassID+"    "+WeekDay+"    "+ClassTime);
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
		boolean flag = sdao.addTeacherCourse(sdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		v = sdao.findTeacherCourse();
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("showTeacherCourse.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！请查看添加信息是否正确！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
	
}
