package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.UserDto;

public class findallBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("222222222222222222");
		Vector<BooksDto> v = new Vector<BooksDto>();
		BooksDao bd = new  BooksDao();
		v = bd.findallBooksInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allbook", v);
		resp.sendRedirect("ShowAllBook.jsp");  //执行完后跳转页面
		
	}


}
