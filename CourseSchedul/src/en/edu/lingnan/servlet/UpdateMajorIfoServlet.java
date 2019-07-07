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



public class UpdateMajorIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String MajorID = null;
		String MajorName = null;
		MajorID = req.getParameter("MajorID");
		MajorName = req.getParameter("MajorName");
		MajorName = new String(MajorName.getBytes("iso-8859-1"),"GB2312");
		int MIflag = Integer.parseInt(req.getParameter("MIflag"));
		System.out.println(MajorID+" "+MajorName+" "+MIflag);
		datebaseDto sdto = new datebaseDto();
		datebaseDao d = new datebaseDao();
		sdto.setMajorID(MajorID);
		sdto.setMajorName(MajorName);
		sdto.setMIflag(MIflag);
		boolean flag =d.UpdateMajorIfo(sdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		v = d.FindMajorIfo();
		HttpSession s = req.getSession();
		s.setAttribute("majorIfo", v);
		resp.sendRedirect("FindMajorIfo1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
