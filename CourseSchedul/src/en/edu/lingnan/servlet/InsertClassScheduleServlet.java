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
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.ClassScheduleDTO;
import en.edu.lingnan.Dto.UserDto;

public class InsertClassScheduleServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String ClassScheduleID = req.getParameter("ClassScheduleID");
		String ClassID = req.getParameter("ClassID");
		String CourseID = req.getParameter("CourseID");
		String WeekDay=new String (req.getParameter("WeekDay").getBytes("ISO-8859-1"));
		String ClassTime=new String (req.getParameter("ClassTime").getBytes("ISO-8859-1"));
		String TeacherID = req.getParameter("TeacherID");
		String ClassroomID = req.getParameter("ClassroomID");	
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
		boolean flag = d.insertClassScheduleInfo(sdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		Vector<ClassScheduleDTO> v = new Vector<ClassScheduleDTO>();
		v = d.findAllClassScheduleInfo();
		HttpSession s = req.getSession();
		s.setAttribute("classSchedule", v);
		resp.sendRedirect("FindClassSchedule1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！请查看添加信息是否正确！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/FindClassSchedule1.jsp");
		}
	}

}