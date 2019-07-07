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



public class SelectMajorIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String MajorID = null;
		MajorID = req.getParameter("MajorID");
		System.out.print(MajorID);
		datebaseDao d = new datebaseDao();
		HttpSession s = req.getSession();
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		v = d.SelectMajorIfoByMajorID(MajorID);
		s.setAttribute("majorIfo", v);
		resp.sendRedirect("FindMajorIfo1.jsp");
	}
}
