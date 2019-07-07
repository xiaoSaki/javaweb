package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import en.edu.lingnan.Dao.UserInformationDAO;
import en.edu.lingnan.Dto.UserInformationDTO;




public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//所有的servelt都是三个步骤
		//1、从客户端接收页面传过来的数据,这里是4个
		String userid=null;
		String username=null;
		String userpassword=null;
		String usersex=null;
		int userAuth=0;
		int flag=1;
		userid=req.getParameter("userid");
		//使用ISO-8859-1字符集解码,解决注册时中文传到后台乱码问题
		username=new String(req.getParameter("username").getBytes("ISO-8859-1"));
		userpassword=req.getParameter("userpassword");
		//使用ISO-8859-1字符集解码,解决注册时中文传到后台乱码问题
		usersex=new String(req.getParameter("usersex").getBytes("ISO-8859-1"));
		userAuth=Integer.parseInt(req.getParameter("userAuth"));
		//flag=Integer.parseInt(req.getParameter("flag"));
		System.out.println("1:"+userid+"  "+username+"  "+userpassword+"  "+usersex+"  "+userAuth+"  "+flag);
		
		//2、处理数据：调用后台的业务逻辑去处理（DAO里面得方法）
		UserInformationDAO udao=new UserInformationDAO();
		UserInformationDTO udto=new UserInformationDTO();
		udto.setUserID(userid);
		udto.setUserName(username);
		udto.setUserPsw(userpassword);
		udto.setUserSex(usersex);
		udto.setUserAuth(userAuth);
		udto.setUIflag(flag);
		boolean flag1 = udao.addUserInfo(udto);
		//3、根据结果去到相应页面
			if(flag1)		
			resp.sendRedirect(req.getContextPath()+"/login.html");
			else
				resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
