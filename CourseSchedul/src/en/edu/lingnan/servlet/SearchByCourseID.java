package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;



public class SearchByCourseID extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
				//所有的servelt都是三个步骤
				//1、从客户端接收页面传过来的数据
				String CourseID=req.getParameter("CourseID");
				System.out.println("1-1-1-1:"+CourseID);
				
				//2、处理数据：调用后台的业务逻辑去处理（DAO里面得方法）
				MajorScheduleDAO mdao=new MajorScheduleDAO();
				Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
				v=mdao.findMajorScheduleByID(CourseID);
//				System.out.println(v);
				HttpSession s = req.getSession();
				s.setAttribute("searchcourse", v);
				s.setAttribute("CourseID", CourseID);
				resp.sendRedirect("MajorScheduleList1.jsp");
	}	

}
