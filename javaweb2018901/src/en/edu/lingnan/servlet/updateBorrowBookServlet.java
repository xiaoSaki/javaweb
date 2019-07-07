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
import en.edu.lingnan.Dao.BorrowBookDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.BorrowBookDto;

public class updateBorrowBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String bbid=new String(req.getParameter("bbid").getBytes("ISO-8859-1"));
		String bcid=new String(req.getParameter("bcid").getBytes("ISO-8859-1"));
		String borrowtime=new String(req.getParameter("borrowtime").getBytes("ISO-8859-1"));
		String returntime=new String(req.getParameter("returntime").getBytes("ISO-8859-1"));
		String duetime=new String(req.getParameter("duetime").getBytes("ISO-8859-1"));
		String mun1 = new String(req.getParameter("mun").getBytes("ISO-8859-1"),"UTF-8");
		int mun = Integer.parseInt(mun1); 
		String fine1=req.getParameter("fine");
		Double fine = Double.parseDouble(fine1);
		String state=new String(req.getParameter("state").getBytes("ISO-8859-1"));
		System.out.println("+++++++++++++++++++++");
		Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
		BorrowBookDao kd = new  BorrowBookDao();
		BorrowBookDto td = new  BorrowBookDto();
		td.setBbid(bbid);
		td.setBcid(bcid);
		td.setBorrowtime(borrowtime);
		td.setBreturntime(returntime);
		td.setBfine(fine);
		td.setBmun(mun);
		td.setBduetime(duetime);
		td.setBreturnstate(state);
		boolean flag=kd.UndateBorrowBooksInfo(td);   //调用修改函数
		if(flag)
		{
	    JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		v=kd.findallBorrowBookInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allborrowbook", v);
		resp.sendRedirect("ShowAllBorrowBook.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
		
	}


}
