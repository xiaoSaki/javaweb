package en.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dto.BooksDto;

public class findBookByidServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException ,java.io.IOException {
	Vector<BooksDto> v = new Vector<BooksDto>();
	BooksDao ad = new  BooksDao();
	String bid = null;
	bid=req.getParameter("Bid");
	//System.out.print("000------"+bid);
	v = ad.findBooksid(bid);
	HttpSession s = req.getSession();
	s.setAttribute("allbook", v);
	resp.sendRedirect("ShowBookByid.jsp");  //执行完后跳转页面
	
}

}
