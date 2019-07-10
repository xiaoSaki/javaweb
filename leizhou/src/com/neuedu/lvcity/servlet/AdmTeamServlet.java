package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.neuedu.lvcity.model.TeamVO;
import com.neuedu.lvcity.service.AdmTeamService;
import com.neuedu.lvcity.service.impl.AdmTeamServiceImpl;


public class AdmTeamServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmTeamServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findTeam".equals(action)){
			List<TeamVO> list = new ArrayList<TeamVO>();
			HttpSession s = req.getSession();
			AdmTeamService admTeamVOService = new AdmTeamServiceImpl();
			list = admTeamVOService.findTeamVO();
			s.setAttribute("teamList", list);
			resp.sendRedirect("team_management.jsp");
		}if("deleteTeam".equals(action)){
			int teamid = Integer.parseInt(req.getParameter("teamid"));
			AdmTeamService admTeamVOService = new AdmTeamServiceImpl();
			boolean flag = admTeamVOService.deleteTeamVO(teamid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除团队信息成功");
				resp.sendRedirect("admTeamServlet?action=findTeam");
			}
			
		}if("addTeam".equals(action)){
			System.out.println("jkajxkhk");
			String content = req.getParameter("content");
			TeamVO team = new TeamVO();
			team.setContent(content);
			AdmTeamService admTeamVOService = new AdmTeamServiceImpl();
			boolean flag = admTeamVOService.addTeamVO(team);
			if(flag){
				resp.sendRedirect("admTeamServlet?action=findTeam");
			}else{
				resp.sendRedirect("team_management_add.jsp");
			}
		}if("updateTeam".equals(action)){
			System.out.println("进入更新。。。。");
			int teamid = Integer.parseInt(req.getParameter("teamid"));
		
			AdmTeamService admTeamVOService = new AdmTeamServiceImpl();
			String content = req.getParameter("content");
			TeamVO team = new TeamVO();
			team.setTeamid(teamid);
			team.setContent(content);
			boolean flag = admTeamVOService.updateTeamVO(team);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admTeamServlet?action=findTeam");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}if("findupdateTeam".equals(action)){
			int teamid = Integer.parseInt(req.getParameter("teamid").trim());
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmTeamService admTeamVOService = new AdmTeamServiceImpl();
			TeamVO team = admTeamVOService.findTeamVOByid(teamid);
			s.setAttribute("team", team);
			//resp.sendRedirect(req.getContextPath()+"notice_management_update.jsp");
			resp.sendRedirect("team_management_update.jsp");
		}
	}

}
