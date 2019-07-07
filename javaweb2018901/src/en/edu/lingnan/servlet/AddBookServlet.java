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
public class AddBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String bid=req.getParameter("Bid");
		String reference_number = new String(req.getParameter("Breference_number").getBytes("ISO-8859-1"),"UTF-8");
		String state = new String(req.getParameter("Bstate").getBytes("ISO-8859-1"),"UTF-8");
		String price1 = new String(req.getParameter("Bprice").getBytes("ISO-8859-1"),"UTF-8");
		Double price = Double.parseDouble(price1);
		String mun1 = new String(req.getParameter("Bmun").getBytes("ISO-8859-1"),"UTF-8");
		int mun = Integer.parseInt(mun1); 
		String name = new String(req.getParameter("Bname").getBytes("ISO-8859-1"),"UTF-8");
		String author = new String(req.getParameter("Bauthor").getBytes("ISO-8859-1"),"UTF-8");
		//2
		Vector<BooksDto> v = new Vector<BooksDto> ();
		BooksDao kd = new  BooksDao();
		BooksDto td = new  BooksDto();
		td.setBookId(bid);
		System.out.println("======-----==="+bid);
		td.setBreference_number(reference_number);
		td.setBookName(name);
		td.setBookauthor(author);
		td.setBprice(price);
		td.setBookstate(state);
		td.setNum(mun);
	    boolean flag = kd.addBooksInfo(td); //调用修改函数
	    if(flag)
	    {
			v = kd.findallBooksInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allbook", v);
			resp.sendRedirect("ShowAllBook.jsp");
	    	System.out.print("-------------------------kkkk");
	    }
	    else {
	    	   resp.sendRedirect(req.getContextPath()+"/admin/addBook.html");
	    	   System.out.print("-------------------------kkkk00000000000000");
		}	
	}
}
