package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.datebaseDao;
import en.edu.lingnan.Dto.datebaseDto;


public class DeleteMajorIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		String MajorID = req.getParameter("MajorID");
//		System.out.println(MajorID);
		datebaseDao d = new datebaseDao();
		boolean flag = d.DeleteMajorIfo(MajorID);
	    if(flag)
	    {
	    JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		HttpSession s = req.getSession();
		s.setAttribute("majorIfo", v);
		resp.sendRedirect("FindMajorIfo1.jsp");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
