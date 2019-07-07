package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.ClassScheduleDAO;
import en.edu.lingnan.Dto.ClassScheduleDTO;
import en.edu.lingnan.Dto.ClassRoomUseDto;

public class UpdateClassScheduleServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassScheduleID = null;
		String ClassID = null;
		String CourseID = null;
		String WeekDay = null;
		String ClassTime = null;
		String TeacherID = null;
		String ClassroomID = null;	
		ClassScheduleID = req.getParameter("ClassScheduleID");
		ClassID = req.getParameter("ClassID");
		CourseID = req.getParameter("CourseID");
		WeekDay = req.getParameter("WeekDay");
		WeekDay = new String(WeekDay.getBytes("iso-8859-1"),"GB2312");
		ClassTime = req.getParameter("ClassTime");
		ClassTime = new String(ClassTime.getBytes("iso-8859-1"),"GB2312");
		TeacherID = req.getParameter("TeacherID");
		ClassroomID = req.getParameter("ClassroomID");	
		System.out.println(ClassScheduleID+" "+WeekDay+" "+ClassTime);
		ClassScheduleDTO sdto = new ClassScheduleDTO();
		ClassScheduleDAO d = new ClassScheduleDAO();
		sdto.setClassScheduleID(ClassScheduleID);
		sdto.setClassID(ClassID);
		sdto.setCourseID(CourseID);
		sdto.setWeekday(WeekDay);
		sdto.setClassTime(ClassTime);
		sdto.setTeacherId(TeacherID);
		sdto.setClassroomID(ClassroomID);
		//sdto.setCSflag(CSflag);
		boolean flag =d.updateClassScheduleInfo(sdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		Vector<ClassScheduleDTO> v = new Vector<ClassScheduleDTO>();
		v = d.findAllClassScheduleInfo();
		HttpSession s = req.getSession();
		s.setAttribute("classSchedule", v);
		resp.sendRedirect("FindClassSchedule1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看修改信息是否正确！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
