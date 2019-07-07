package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dto.ClassRoomDto;

public class findClassRoomByIDServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException ,java.io.IOException {
	Vector<ClassRoomDto> v = new Vector<ClassRoomDto>();
	ClassRoomDao ad = new  ClassRoomDao();
	String cid = null;
	cid=req.getParameter("Cid");
	//System.out.print("000------"+bid);
	v = ad.findClassRoomByid(cid);
	HttpSession s = req.getSession();
	s.setAttribute("allclassroom", v);
	resp.sendRedirect("ShowClassRoomById.jsp");  //执行完后跳转页面
	}
}
