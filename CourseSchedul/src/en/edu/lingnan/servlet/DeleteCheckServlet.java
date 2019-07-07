package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;


public class DeleteCheckServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String[] arr=req.getParameterValues("arr");//获取从页面传过来的arr数组
		MajorScheduleDAO mdao=new MajorScheduleDAO();
		for(String a : arr){
			String [] b=a.split(",");//用逗号把字符串进行分隔
			for(String c:b)
				mdao.deleteMajorScheduleById(c);
		}
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findAllMajorSchedule();
		HttpSession s = req.getSession();
		s.setAttribute("allMajorSchedule", v);
		resp.sendRedirect("MajorScheduleList.jsp");
	
	}


}
