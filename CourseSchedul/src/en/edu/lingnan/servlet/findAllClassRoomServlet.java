package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dto.ClassRoomDto;

public class findAllClassRoomServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto>();
		ClassRoomDao ad = new  ClassRoomDao();
		v = ad.findClassRoomInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroom", v);
		resp.sendRedirect("ShowAllclassRoom.jsp");  //执行完后跳转页面
		
	}

}


