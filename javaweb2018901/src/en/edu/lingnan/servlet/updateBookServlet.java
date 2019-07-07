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

public class updateBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String bid=new String(req.getParameter("bid").getBytes("ISO-8859-1"));
		String bname=new String(req.getParameter("bname").getBytes("ISO-8859-1"));
		String bauthor=new String(req.getParameter("bauthor").getBytes("ISO-8859-1"));
		String bnum=new String(req.getParameter("bnum").getBytes("ISO-8859-1"));
		String bmun=new String(req.getParameter("bmun").getBytes("ISO-8859-1"));
		int mun = Integer.parseInt(bmun); 
		String price=req.getParameter("bprice");
		Double bprice = Double.parseDouble(price);
		String bstate=new String(req.getParameter("bstate").getBytes("ISO-8859-1"));
		//System.out.println(password);
		Vector<BooksDto> v = new Vector<BooksDto> ();
		BooksDao kd = new  BooksDao();
		BooksDto td = new  BooksDto();
		
		td.setBookId(bid);
		System.out.println("======-----==="+bid);
		td.setBreference_number(bnum);
		td.setBookName(bname);
		td.setBookauthor(bauthor);
		td.setBprice(bprice);
		td.setNum(mun);
		td.setBookstate(bstate);
		boolean flag =kd.UpdateBooksInfo(td);    //调用修改函数
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		v=kd.findallBooksInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allbook", v);
		resp.sendRedirect("ShowAllBook.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
	}

}
