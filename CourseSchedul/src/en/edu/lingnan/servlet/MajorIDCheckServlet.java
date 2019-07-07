package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import en.edu.lingnan.Dao.MajorInformationDAO;


public class MajorIDCheckServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String MajorID=req.getParameter("MajorID");
		System.out.println("MajorID:   "+MajorID);
		MajorInformationDAO mdao=new MajorInformationDAO();
		boolean flag = mdao.FindMajorInfoByID(MajorID);
		if(!flag){
			resp.getWriter().print("false"); //把false值返回给页面AddMajorSchedule.jsp
		}
	}

}
