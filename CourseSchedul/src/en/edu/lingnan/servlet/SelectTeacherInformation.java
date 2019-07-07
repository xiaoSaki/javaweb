package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.teacherInformationDAO;
import en.edu.lingnan.Dto.teacherInformationDTO;
public class SelectTeacherInformation extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherID = req.getParameter("TeacherID");
		TeacherID = new String(TeacherID.getBytes("iso8859-1"), "gb2312");// 用于解决数据传输过程中带来的乱码		
		teacherInformationDAO sd = new teacherInformationDAO();
		Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
		v = sd.findTeacherInformationByID(TeacherID);
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("selectTeacherInformation.jsp");
	}
	
}
