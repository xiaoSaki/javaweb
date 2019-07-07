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

public class DeleteUserByidServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 String cid = null;
		 cid = req.getParameter("cid");
		Vector<UserDto> v = new Vector<UserDto> ();
		UserDao ad = new UserDao();
		boolean flag =ad.deleteUsersByid(cid);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);	
		v=ad.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowAllUser.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
		
	}

}