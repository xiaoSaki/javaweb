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

import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.service.AdmNoticeService;
import com.neuedu.lvcity.service.impl.AdmNoticeServiceImpl;

public class AdmNoticeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmNoticeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findNotice".equals(action)){
			List<Notice> list = new ArrayList<Notice>();
			HttpSession s = req.getSession();
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			list = admNoticeService.findNotice();
			s.setAttribute("noticeList", list);
			resp.sendRedirect("notice_management.jsp");
		}if("deleteNotice".equals(action)){
			int nid = Integer.parseInt(req.getParameter("nid"));
			System.out.println("id测试"+nid);
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			boolean flag = admNoticeService.deleteNotice(nid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("admNoticeServlet?action=findNotice");
			}
			
		}if("addNotice".equals(action)){
			System.out.println("jkajxkhk");
			int ntid = Integer.parseInt(req.getParameter("ntid"));
			int aid = Integer.parseInt(req.getParameter("aid"));
			String nname = req.getParameter("nname");
			Notice notice = new Notice();
			notice.setNname(nname);
			notice.setAid(aid);
			notice.setNtid(ntid);
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			boolean flag = admNoticeService.addNotice(notice);
			if(flag){
				resp.sendRedirect("admNoticeServlet?action=findNotice");
			}else{
				resp.sendRedirect("notice_management_add.jsp");
			}
		}if("updateNotice".equals(action)){
			System.out.println("进入更新。。。。");
			int nid = Integer.parseInt(req.getParameter("nid"));
		
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			int ntid = Integer.parseInt(req.getParameter("ntid"));
			int aid = Integer.parseInt(req.getParameter("aid"));
			String nname = req.getParameter("nname");
			Notice notice = new Notice();
			notice.setNname(nname);
			notice.setAid(aid);
			notice.setNtid(ntid);
			notice.setNid(nid);
			boolean flag = admNoticeService.updateNotice(notice);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admNoticeServlet?action=findNotice");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}if("findupdateNotice".equals(action)){
			int nid = Integer.parseInt(req.getParameter("nid").trim());
			
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			Notice notice = admNoticeService.findNoticeByid(nid);
			s.setAttribute("notice", notice);
			//resp.sendRedirect(req.getContextPath()+"notice_management_update.jsp");
			resp.sendRedirect("notice_management_update.jsp");
		}if("findNoticeByname".equals(action)){
			String nname = req.getParameter("nname").trim();
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmNoticeService admNoticeService = new AdmNoticeServiceImpl();
			List<Notice> list  = admNoticeService.findNoticeByname(nname);
			s.setAttribute("list", list);
			//resp.sendRedirect(req.getContextPath()+"notice_management_update.jsp");
			resp.sendRedirect("notice_management.jsp");
		}
	}

}
