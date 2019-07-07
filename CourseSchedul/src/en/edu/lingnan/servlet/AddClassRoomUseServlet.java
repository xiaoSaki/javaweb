package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.ClassRoomUseDao;
import en.edu.lingnan.Dto.ClassRoomUseDto;

public class AddClassRoomUseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		System.out.println("hhhhhhhh");
		resp.setContentType("text/html;charset=GB2312");
		String useid=new String(req.getParameter("useid").getBytes("ISO-8859-1"));
		String cid=new String(req.getParameter("cid").getBytes("ISO-8859-1"));
		String weekday=new String(req.getParameter("weekday").getBytes("ISO-8859-1"));
		String classtime=new String(req.getParameter("classtime").getBytes("ISO-8859-1"));	
		String cstate=new String(req.getParameter("cstate").getBytes("ISO-8859-1"));
		//System.out.println(password);
		Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto> ();
		ClassRoomUseDao kd = new  ClassRoomUseDao();
		ClassRoomUseDto td = new  ClassRoomUseDto();
		td.setRoomUserid(cid);
		td.setRoomid(useid);
	    System.out.println("======-----==="+cid);
	    td.setWeekday(weekday);
		td.setClasstime(classtime);
		td.setUserstate(cstate);
		boolean flag =kd.addClassRoomUseInfo(td);
		if(flag)
		{
	    JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=kd.findClassRoomUseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroomuse", v);
		resp.sendRedirect("ShowAllClassRoomUse.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
	

}
