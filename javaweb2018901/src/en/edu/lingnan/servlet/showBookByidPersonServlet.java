package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dto.BooksDto;

public class showBookByidPersonServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<BooksDto> v = new Vector<BooksDto>();
		BooksDao ad = new  BooksDao();
		String bid = null;
		bid=req.getParameter("Bid");
		//System.out.print("000------"+bid);
		v = ad.findBooksid(bid);
		HttpSession s = req.getSession();
		s.setAttribute("allbook", v);
		resp.sendRedirect("ShowBookByidPerson.jsp");  //执行完后跳转页面
		
	}

}
