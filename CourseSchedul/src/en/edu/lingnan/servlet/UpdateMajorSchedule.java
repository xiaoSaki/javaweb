package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;
public class UpdateMajorSchedule extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String CourseID=req.getParameter("CourseID"); 
		String MajorID=req.getParameter("MajorID");
	 	String CourseName=new String(req.getParameter("CourseName").getBytes("ISO-8859-1"));
		String CourseTime=new String(req.getParameter("CourseTime").getBytes("ISO-8859-1"));
		String YearTime=new String(req.getParameter("YearTime").getBytes("ISO-8859-1"));
		String TermTime=new String(req.getParameter("TermTime").getBytes("ISO-8859-1"));
//		String MSflag=req.getParameter("MSflag");
//		String flag=req.getParameter("flag");
		String EveryWeekCourseTime1=req.getParameter(" EveryWeekCourseTime");
		int  EveryWeekCourseTime = Integer.parseInt( EveryWeekCourseTime1);
		String ClassroomType=new String(req.getParameter("ClassroomType").getBytes("ISO-8859-1"));
		System.out.println( 999+CourseID+"   "+MajorID+"   "+CourseName+"    "+CourseTime+"   "+YearTime+"    "+TermTime+"  ");
		MajorScheduleDTO mdto = new MajorScheduleDTO();
		MajorScheduleDAO m = new MajorScheduleDAO();
		mdto.setCourseID(CourseID);
		mdto.setMajorID(MajorID);
		mdto.setCourseName(CourseName);
		mdto.setCourseTime(CourseTime);
		mdto.setYearTime(YearTime);
		mdto.setTermTime(TermTime);
	    mdto.setClassroomType(ClassroomType);
	    mdto.setEveryWeekCourseTime(EveryWeekCourseTime);
		//整数要转换一下
//		mdto.setMSflag(Integer.parseInt(MSflag));
//		rdto.setFlag(Integer.parseInt(flag));
		boolean flag = m.updateMajorSchedule(mdto);
		
		 //点击确认修改之后又回到展示所有用户信息的页面
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=m.findAllMajorSchedule();
		HttpSession s = req.getSession();
		s.setAttribute("allMajorSchedule", v);
		resp.sendRedirect("MajorScheduleList.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}

}
