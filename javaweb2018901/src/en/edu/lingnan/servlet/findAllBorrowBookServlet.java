package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.BorrowBookDao;
import en.edu.lingnan.Dto.BorrowBookDto;

public class findAllBorrowBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<BorrowBookDto> v = new Vector<BorrowBookDto>();
		BorrowBookDao bdao = new  BorrowBookDao();
		v = bdao.findallBorrowBookInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allborrowbook", v);
		resp.sendRedirect("ShowAllBorrowBook.jsp");  //执行完后跳转页面
			
	}
}
