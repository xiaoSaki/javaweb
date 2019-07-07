package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dao.ClassRoomUseDao;
import en.edu.lingnan.Dao.UserDao;

import en.edu.lingnan.Dto.ClassRoomUseDto;
public class findAllClassRoomUseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto>();
		ClassRoomUseDao ad = new ClassRoomUseDao();
		v = ad.findClassRoomUseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroomuse", v);
		resp.sendRedirect("ShowAllClassRoomUse.jsp");  //执行完后跳转页面
		
	}


}
