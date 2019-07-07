/*package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.UserInformationDAO;


public class LoginServelt extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		//所有的servelt都是三个步骤
		//1、从客户端接收页面传过来的数据
		String userid=null;
		String username=null;
		String password=null;
		userid=req.getParameter("userid");
		password=req.getParameter("password");
		System.out.println("1:"+userid+"  "+password);
		
		//2、处理数据：调用后台的业务逻辑去处理（判断这个用户名和密码是否存在且对应）（DAO里面得方法）
		UserInformationDAO udao=new UserInformationDAO();
		int superValue= udao.FindUserByIdAndPassword(userid, password);
//		Boolean flag= rdo.FINDReaderByIdAndPassword(userid, password);
			System.out.println("---2-----"+superValue);
//		System.out.println("---2-----"+flag);
			HttpSession s=req.getSession();
			s.setAttribute("superValue", superValue);
			s.setAttribute("userid", userid);
		//根据你的处理结果返回到相应页面
			if(superValue!=0)
			{
				if(superValue==2)
				{
					resp.sendRedirect(req.getContextPath()+"/teacher/ok.jsp?userid="+userid+"");
				}
				else if(superValue==3)
				{					
					resp.sendRedirect(req.getContextPath()+"/student/student.jsp?userid="+userid+"");
				}
			}						 	
			else 
				resp.sendRedirect(req.getContextPath()+"/error.html?userid="+userid+"");	
	}

}*/
