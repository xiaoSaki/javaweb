package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;



public class DeleteMajorScheduleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//super.doGet(req,resp);
		String CourseID=req.getParameter("CourseID");
		String userid=req.getParameter("userid");
//		System.out.println("2222222222222222222222:    "+rid);
		MajorScheduleDAO m = new MajorScheduleDAO();
		boolean flag=m.deleteMajorScheduleById(CourseID); //删完应该弹出一个框说删除成功
		if(flag)
		{
		//删完之后重新查询所有，不然读到的是原来的 vector
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=m.findAllMajorSchedule();
		HttpSession s = req.getSession();
		s.setAttribute("allMajorSchedule", v);
		s.setAttribute("userid",userid);
		resp.sendRedirect("MajorScheduleList.jsp?");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}

}
}
