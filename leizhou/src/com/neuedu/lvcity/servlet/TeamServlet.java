package com.neuedu.lvcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.TeamVO;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.TeamService;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;
import com.neuedu.lvcity.service.impl.TeamServiceImpl;



public class TeamServlet extends HttpServlet {
	/**
	 * 鏋勯�犳柟娉曪紵锛燂紵
	 */
	public TeamServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest requset, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(requset.getContextPath());
		doPost(requset, response);
	}
	
	/**
	 @see HttpServlet#doGetdoPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//闃叉鍙栦腑鏂囧弬鏁板嚭鐜颁贡鐮�
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//鑾峰彇session
		HttpSession session = request.getSession();
		//璋冪敤Service鏂规硶
		ContactService contactService = ContactServiceImpl.getInstance();
		/*Contact contact = contactService.findContact(1);
		session.setAttribute("contact",contact);*/
		
		TeamService teamService = TeamServiceImpl.getInstance();
		TeamVO team = teamService.findTeamById(1);
		session.setAttribute("team",team);
		response.sendRedirect(request.getContextPath()+"/User/team.jsp");
		
		
	}
}
