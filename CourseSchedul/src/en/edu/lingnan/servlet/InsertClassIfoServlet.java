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


public class InsertClassIfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassID = null;
		String ClassName = null;
		String MajorID = null;
		req.setCharacterEncoding("utf-8");
		ClassID = req.getParameter("ClassID");
		ClassName = req.getParameter("ClassName");
		ClassName = new String(ClassName.getBytes("iso-8859-1"),"GB2312");
		MajorID = req.getParameter("MajorID");
		int ClassNumber = Integer.parseInt(req.getParameter("ClassNumber"));
		int CIflag = Integer.parseInt(req.getParameter("CIflag"));
		System.out.println(ClassID + " " + ClassName + " " + MajorID + " "
				+" "+ClassNumber+" "+ CIflag);
		datebaseDao d = new datebaseDao();
		datebaseDto sdto = new datebaseDto();
		Vector<datebaseDto> v = new Vector<datebaseDto>();
		sdto.setClassID(ClassID);
		sdto.setClassName(ClassName);
		sdto.setMajorID(MajorID);
		sdto.setClassNumber(ClassNumber);
		sdto.setCIflag(CIflag);
		boolean flag = d.InsertClassIfo(sdto);
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);	
		v = d.FindClassIfo();
		HttpSession s = req.getSession();
		s.setAttribute("classIfo", v);
		resp.sendRedirect("FindClassIfo1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！请查看添加信息是否正确！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}
}
