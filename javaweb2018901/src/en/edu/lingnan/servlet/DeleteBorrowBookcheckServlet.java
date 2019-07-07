package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.net.www.content.audio.aiff;
import en.edu.lingnan.Dao.BooksDao;
import en.edu.lingnan.Dao.BorrowBookDao;
import en.edu.lingnan.Dao.StudentDao;
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.BorrowBookDto;

public class DeleteBorrowBookcheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String[] arr = req.getParameterValues("arr");
	BorrowBookDao sdao = new BorrowBookDao();
	String[] b = null;
	//String[] c = null;
	String[] d = null;
	for(String a : arr){
		b = a.split(",");
		//System.out.println("bbbbb"+b);
		for(String f : b)
		{
			d = f.split(" ");	
			
			for(String e : d)
			{
				System.out.println("kkk"+e);
			}
			
			int i=0;
			sdao.deleteBorrowBooksByid(d[0+2*i],d[1+2*i]);
			i++;
			
		}	
	}
	Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
	v=sdao.findallBorrowBookInfo();
	HttpSession s = req.getSession();
	s.setAttribute("allborrowbook", v);
	resp.sendRedirect("ShowAllBorrowBook.jsp");
	}
}
