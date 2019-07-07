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

public class DeleteClassIfoCheckServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		datebaseDao d = new datebaseDao();
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		String[] arr1 = req.getParameterValues("arr");
		for(String a : arr1){
			String[] b = a.split(",");   //用","对数组a进行分割
			for(String c : b)
				v = d.DeleteClassIfoByClassID(c);
		}
		
//		v = d.FindClassIfo();
		HttpSession s = req.getSession();
		s.setAttribute("classIfo", v);
		resp.sendRedirect("FindClassIfo.jsp");
	}
}
