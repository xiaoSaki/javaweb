package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.BorrowBookDao;
import en.edu.lingnan.Dto.BorrowBookDto;

public class ReturnBookPersonServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bbid = null; 
		String bcid= null;
		bbid = req.getParameter("bbid");
		bcid = req.getParameter("bcid");
		Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
		BorrowBookDao kd = new  BorrowBookDao();
		boolean flag = kd.deleteBorrowBooksByid(bbid, bcid);
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "还书成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
			v=kd.findallBorrowBookInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allborrowbook", v);
			resp.sendRedirect("ShowBorrowBookperson.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "还书失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/person_mian.html");
		}
	}


}
