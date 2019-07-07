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
public class DeleteClassIfoServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		String ClassID = req.getParameter("ClassID");
//		System.out.println(ClassID);
		datebaseDao d = new datebaseDao();
		boolean flag=d.DeleteClassIfo(ClassID);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		HttpSession s = req.getSession();
		s.setAttribute("classIfo", v);
		resp.sendRedirect("FindClassIfo1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
