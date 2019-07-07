package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.UserDto;

public class deleteBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bid = null; 
		bid = req.getParameter("bid");
		Vector<BooksDto> v = new Vector<BooksDto> ();
		BooksDao kd = new  BooksDao();
		boolean flag = kd.deleteBooksid(bid);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v=kd.findallBooksInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allbook", v);
		resp.sendRedirect("ShowAllBook.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
	}


}
