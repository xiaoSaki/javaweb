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


public class UpdateClassIfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassID = null;
		String ClassName = null;
		String MajorID = null;
		ClassID = req.getParameter("ClassID");
		ClassName = req.getParameter("ClassName");
		ClassName = new String(ClassName.getBytes("iso-8859-1"),"GB2312");
		MajorID = req.getParameter("MajorID");
		int ClassNumber = Integer.parseInt(req.getParameter("ClassNumber"));
		int CIflag = Integer.parseInt(req.getParameter("CIflag"));
		System.out.println(ClassID+" "+ClassName+" "+MajorID+" "+" "+ClassNumber+" "+CIflag);
		datebaseDto sdto = new datebaseDto();
		datebaseDao d = new datebaseDao();
		sdto.setClassID(ClassID);
		sdto.setClassName(ClassName);
		sdto.setMajorID(MajorID);
		sdto.setClassNumber(ClassNumber);
		sdto.setCIflag(CIflag);
		boolean falg= d.UpdateClassIfo(sdto);
		if(falg)
		{
		JOptionPane.showMessageDialog(null, "更新成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		v = d.FindClassIfo();
		HttpSession s = req.getSession();
		s.setAttribute("classIfo", v);
		resp.sendRedirect("FindClassIfo1.jsp");		
		}
		else {
			JOptionPane.showMessageDialog(null, "更新失败，请查看是否有改教室存在！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
