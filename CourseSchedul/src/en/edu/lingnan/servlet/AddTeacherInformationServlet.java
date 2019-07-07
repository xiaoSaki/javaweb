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

public class AddTeacherInformationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherID = req.getParameter("TeacherID");
		TeacherID = new String(TeacherID.getBytes("iso8859-1"), "gb2312");// 用于解决数据传输过程中带来的乱码
		String TeacherName = req.getParameter("TeacherName");
		TeacherName = new String(TeacherName.getBytes("iso8859-1"), "gb2312");
		String TeacherSex = req.getParameter("TeacherSex");
		TeacherSex = new String(TeacherSex.getBytes("iso8859-1"), "gb2312");
		String TeacherTel = req.getParameter("TeacherTel");
		TeacherTel = new String(TeacherTel.getBytes("iso8859-1"), "gb2312");
		String TeacherAge = req.getParameter("TeacherAge");
		TeacherAge = new String(TeacherAge.getBytes("iso8859-1"), "gb2312");
		String TIflag = req.getParameter("TIflag");
		TIflag = new String(TIflag.getBytes("iso8859-1"), "gb2312");
		System.out.println(TeacherID+"    "+TeacherName+"    "+TeacherSex+"    "+TeacherTel+"    "+TeacherAge+"    "+TIflag);
		teacherInformationDTO sdto = new teacherInformationDTO();
		teacherInformationDAO sdao = new teacherInformationDAO();
		sdto.setTeacherID(TeacherID);
		sdto.setTeacherName(TeacherName);
		sdto.setTeacherSex(TeacherSex);
		sdto.setTeacherTel(TeacherTel);
		sdto.setTeacherAge(Integer.parseInt(TeacherAge));
		sdto.setTIflag(Integer.parseInt(TIflag));
		boolean flag = sdao.addTeacherInformation(sdto);
		Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
		v = sdao.findTeacherInformation();
		HttpSession s = req.getSession();
		s.setAttribute("TeacherUser", v);
		resp.sendRedirect("showTeacherInformation.jsp");
	}
	
}
