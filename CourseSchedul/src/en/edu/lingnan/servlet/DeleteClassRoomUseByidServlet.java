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
import en.edu.lingnan.Dao.ClassRoomUseDao;
import en.edu.lingnan.Dto.ClassRoomDto;
import en.edu.lingnan.Dto.ClassRoomUseDto;

public class DeleteClassRoomUseByidServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cid = null; 
		cid = req.getParameter("cid");
		Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto> ();
		ClassRoomUseDao ad = new ClassRoomUseDao();
		boolean flag =ad.deleteClassRoomUseByid(cid);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=ad.findClassRoomUseInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allclassroomuse", v);
		resp.sendRedirect("ShowAllClassRoomUse.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin.html");
		}
		
	}

}
