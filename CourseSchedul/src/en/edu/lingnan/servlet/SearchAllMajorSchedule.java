package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;

public class SearchAllMajorSchedule extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("123");
		MajorScheduleDAO mdao = new MajorScheduleDAO();
		
//		String userid=req.getParameter("userid");
//		System.out.println("yyy"+userid);
		HttpSession s = req.getSession();
//		s.setAttribute("userid", userid);
		
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findAllMajorSchedule();
		s.setAttribute("allMajorSchedule", v);
		resp.sendRedirect("MajorScheduleList.jsp");
	}



}
