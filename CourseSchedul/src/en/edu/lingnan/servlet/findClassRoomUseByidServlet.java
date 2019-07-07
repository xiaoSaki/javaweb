package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dao.ClassRoomUseDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.ClassRoomUseDto;

public class findClassRoomUseByidServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException ,java.io.IOException {
	Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto>();
	ClassRoomUseDao ad = new  ClassRoomUseDao();
	String cid = null;
	cid=req.getParameter("Cid");
	System.out.print("000hhhhh------"+cid);
	v = ad.findClassRoomUseByid(cid);
	HttpSession s = req.getSession();
	s.setAttribute("allclassroomuse", v);
	resp.sendRedirect("ShowClassRoomUseById.jsp");  //执行完后跳转页面
	}

}
