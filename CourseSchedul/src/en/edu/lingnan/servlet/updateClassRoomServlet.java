package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.ClassRoomDao;
import en.edu.lingnan.Dto.ClassRoomDto;

public class updateClassRoomServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		System.out.println("hhhhhhhh");
		resp.setContentType("text/html;charset=GB2312");
		String cid=new String(req.getParameter("cid").getBytes("ISO-8859-1"));
		String cname=new String(req.getParameter("cname").getBytes("ISO-8859-1"));	
		String ctype=new String(req.getParameter("ctype").getBytes("ISO-8859-1"));
		String maxnum1=req.getParameter("maxnum");
		int maxnum = Integer.parseInt(maxnum1);
		//System.out.println(password);
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
		ClassRoomDao kd = new  ClassRoomDao();
		ClassRoomDto td = new  ClassRoomDto();
		
		td.setRoomid(cid);
		System.out.println("======-----==="+cid);
		td.setRoomname(cname);
		td.setMaxnum(maxnum);
		td.setRoomtype(ctype);
		kd.UpdateClassRoomInfo(td);
		
		v=kd.findClassRoomInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroom", v);
		resp.sendRedirect("ShowAllclassRoom.jsp");
	}
	
}
