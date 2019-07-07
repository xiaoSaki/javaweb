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

public class SelectClassIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassID = null;
		ClassID = req.getParameter("ClassID");
		System.out.print(ClassID);
		datebaseDao d = new datebaseDao();
		HttpSession s = req.getSession();
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		v = d.SelectClassIfoByClassID(ClassID);
		s.setAttribute("classIfo", v);
		resp.sendRedirect("FindClassIfo1.jsp");
	}
}
