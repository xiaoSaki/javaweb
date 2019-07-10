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

import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.service.AdmNoticeTypeService;
import com.neuedu.lvcity.service.impl.AdmNoticeTypeServiceImpl;


public class AdmNoticeTypeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmNoticeTypeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findNoticetype".equals(action)){
			List<Noticetype> list = new ArrayList<Noticetype>();
			HttpSession s = req.getSession();
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			list = admNoticetypeService.findNoticetype();
			s.setAttribute("noticetypeList", list);
			resp.sendRedirect("noticetype_management.jsp");
		}if("deleteNoticetype".equals(action)){
			int ntid = Integer.parseInt(req.getParameter("ntid"));
			System.out.println("id测试"+ntid);
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			boolean flag = admNoticetypeService.deleteNoticetype(ntid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("admNoticeTypeServlet?action=findNoticetype");
			}
			
		}if("addNoticetype".equals(action)){
			System.out.println("jkajxkhk");
			String nt = req.getParameter("nt");
			Noticetype noticetype = new Noticetype();
			noticetype.setNt(nt);
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			boolean flag = admNoticetypeService.addNoticetype(noticetype);
			if(flag){
				resp.sendRedirect("admNoticeTypeServlet?action=findNoticetype");
			}else{
				resp.sendRedirect("noticetype_management_add.jsp");
			}
		}if("updateNoticetype".equals(action)){
			System.out.println("进入更新。。。。");
			int nid = Integer.parseInt(req.getParameter("nid"));
		
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			int ntid = Integer.parseInt(req.getParameter("ntid"));
			String nt = req.getParameter("nt");
			Noticetype noticetype = new Noticetype();
			noticetype.setNt(nt);
			noticetype.setNtid(ntid);
			boolean flag = admNoticetypeService.updateNoticetype(noticetype);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admNoticeTypeServlet?action=findNoticetype");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}if("findupdateNoticetype".equals(action)){
			int nid = Integer.parseInt(req.getParameter("nid").trim());
			
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			Noticetype noticetype = admNoticetypeService.findNoticetypeByid(nid);
			s.setAttribute("noticetype", noticetype);
			//resp.sendRedirect(req.getContextPath()+"notice_management_update.jsp");
			resp.sendRedirect("noticetype_management_update.jsp");
		}if("findNoticetypeByname".equals(action)){
			String nname = req.getParameter("nname").trim();
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmNoticeTypeService admNoticetypeService = new AdmNoticeTypeServiceImpl();
			List<Noticetype> list  = admNoticetypeService.findNoticetypeByname(nname);
			s.setAttribute("list", list);
			//resp.sendRedirect(req.getContextPath()+"notice_management_update.jsp");
			resp.sendRedirect("noticetype_management_update.jsp");
		}
	}

}
