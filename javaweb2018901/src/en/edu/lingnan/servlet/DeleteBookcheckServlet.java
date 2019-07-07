package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.StudentDto;

public class DeleteBookcheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String[] arr = req.getParameterValues("arr");
	BooksDao sdao = new BooksDao();
	for(String a : arr){
		String[] b = a.split(",");
	for(String c : b)
		sdao.deleteBooksid(c);
}
	Vector<BooksDto> v = new Vector<BooksDto> ();
	v=sdao.findallBooksInfo();
	HttpSession s = req.getSession();
	s.setAttribute("allbook", v);
	resp.sendRedirect("ShowAllBook.jsp");
}

}
