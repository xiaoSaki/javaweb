package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.datebaseDao;
import en.edu.lingnan.Dto.datebaseDto;



public class FindMajorIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		datebaseDao d = new datebaseDao();
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		v = d.FindMajorIfo();
		HttpSession s = req.getSession();
		s.setAttribute("majorIfo", v);
//		for(datebaseDto a : v){
//			System.out.print(a.getMajorID());
//		}
		resp.sendRedirect("FindMajorIfo1.jsp");
	}
}
