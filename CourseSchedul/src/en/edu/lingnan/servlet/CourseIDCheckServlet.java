package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import en.edu.lingnan.Dao.MajorScheduleDAO;






public class CourseIDCheckServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String CourseID=req.getParameter("CourseID");
		System.out.println("CourseID:   "+CourseID);
		MajorScheduleDAO mdao=new MajorScheduleDAO();
		boolean flag = mdao.FindMajorScheduleByID(CourseID);
		System.out.println(flag+"4");
		if(flag){
			resp.getWriter().print("true"); //把true值返回给页面register.html
		}
	}

}
