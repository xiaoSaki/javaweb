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
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.UserDto;

public class DeleteClassRoomByIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cid = null; 
		cid = req.getParameter("cid");
		Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
		ClassRoomDao ad = new ClassRoomDao();
		boolean flag =ad.deleteClassRoomByid(cid);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=ad.findClassRoomInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroom", v);
		resp.sendRedirect("ShowAllclassRoom.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
		
	}

}
