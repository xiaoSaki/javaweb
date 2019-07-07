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
import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.BorrowBookDto;
import en.edu.lingnan.Dto.StudentDto;

public class BorrowBook_personServlet extends HttpServlet {
//	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
//			throws ServletException ,java.io.IOException {
//		req.setCharacterEncoding("GB2312");
//		resp.setContentType("text/html;charset=GB2312");
//		String bbid=new String(req.getParameter("Bbid").getBytes("ISO-8859-1"),"UTF-8");
//		String bsid = new String(req.getParameter("Bsid").getBytes("ISO-8859-1"),"UTF-8");
//		String borrowtime = new String(req.getParameter("Bborrowtime").getBytes("ISO-8859-1"),"UTF-8");
//		String returntime = new String(req.getParameter("Breturntime").getBytes("ISO-8859-1"),"UTF-8");
//		String duetime = new String(req.getParameter("Bduetime").getBytes("ISO-8859-1"),"UTF-8");
//		String mun1 = new String(req.getParameter("Bbmun").getBytes("ISO-8859-1"),"UTF-8");
//		int mun = Integer.parseInt(mun1); 
//		String state = new String(req.getParameter("Bbstate").getBytes("ISO-8859-1"),"UTF-8");
//		String fine1 = new String(req.getParameter("Bfine").getBytes("ISO-8859-1"),"UTF-8");
//		Double fine = Double.parseDouble(fine1); 
//		System.out.print("121212aaaaa"+bbid);
//		System.out.print("121212aaaaa"+bsid);
//		//2
//		Vector<BorrowBookDto> v = new Vector<BorrowBookDto>();
//		BorrowBookDao bdao = new  BorrowBookDao();
//		BorrowBookDto td = new  BorrowBookDto();
//		//System.out.println("======-----==="+sid);
//		td.setBbid(bbid);
//		td.setBcid(bsid);
//		td.setBorrowtime(borrowtime);
//		td.setBreturntime(returntime);
//		td.setBmun(mun);
//		td.setBduetime(duetime);
//		td.setBreturnstate(state);
//		td.setBfine(fine);
//	
//	    boolean flag = bdao.addBorrowBooksInfo(td);//调用修改函数
//	    if(flag)
//	    {
//			v = bdao.findallBorrowBookInfo();
//			HttpSession s = req.getSession();
//			s.setAttribute("allborrowbook", v);
//			resp.sendRedirect("ShowAllBorrowBook.jsp");
//	    	System.out.print("-------------------------kkkk");
//	    }
//	    else {
//	    	if(!(bbid==""||bsid==""||borrowtime==""||returntime==""||state==""||duetime==""))
//	    	{
//	    		JOptionPane.showMessageDialog(null, "借书失败", "提示", JOptionPane.ERROR_MESSAGE);
//	    	}
//	    	resp.sendRedirect(req.getContextPath()+"/admin/addBorrowBook.html");
//	    	
//	    	System.out.print("-------------------------kkkk00000000000000");
//		}
//		
//	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String bbid=new String(req.getParameter("Bbid").getBytes("ISO-8859-1"));
		String bsid = new String(req.getParameter("Bsid").getBytes("ISO-8859-1"),"UTF-8");
		String borrowtime = new String(req.getParameter("Bborrowtime").getBytes("ISO-8859-1"));
		String returntime = new String(req.getParameter("Breturntime").getBytes("ISO-8859-1"));
		String duetime = new String(req.getParameter("Bduetime").getBytes("ISO-8859-1"));
		String mun1 = new String(req.getParameter("Bbmun").getBytes("ISO-8859-1"));
		int mun = Integer.parseInt(mun1); 
		String state = new String(req.getParameter("Bbstate").getBytes("ISO-8859-1"));
		String fine1 = new String(req.getParameter("Bfine").getBytes("ISO-8859-1"));
		Double fine = Double.parseDouble(fine1); 
		System.out.print("121212aaaaa"+bbid);
		System.out.print("121212aaaaa"+bsid);
		//2
		Vector<BorrowBookDto> v = new Vector<BorrowBookDto>();
		BorrowBookDao bdao = new  BorrowBookDao();
		BorrowBookDto td = new  BorrowBookDto();
		//System.out.println("======-----==="+sid);
		td.setBbid(bbid);
		td.setBcid(bsid);
		td.setBorrowtime(borrowtime);
		td.setBreturntime(returntime);
		td.setBmun(mun);
		td.setBduetime(duetime);
		td.setBreturnstate(state);
		td.setBfine(fine);
	
	    boolean flag = bdao.addBorrowBooks_Student(td);//调用修改函数
	    if(flag)
	    {
	    	JOptionPane.showMessageDialog(null, "借书成功！", "提示", JOptionPane.PLAIN_MESSAGE);
			v = bdao.findallBorrowBookInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allborrowbook1", v);
			resp.sendRedirect("ShowBorrowBookperson.jsp");
	    	System.out.print("-------------------------==kkkk");
	    }
	    else {
	    	if(!(bbid==""||bsid==""||borrowtime==""||returntime==""||state==""||duetime==""))
	    	{
	    		JOptionPane.showMessageDialog(null, "借书失败！", "提示", JOptionPane.ERROR_MESSAGE);
	    	}
	    	resp.sendRedirect(req.getContextPath()+"/person_mian.html");
	    	
	    	System.out.print("-------------------------kkkk00000000000000");
		}
		
	}



}
