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

import com.neuedu.lvcity.model.Articletype;
import com.neuedu.lvcity.service.AdmArticletypeService;
import com.neuedu.lvcity.service.impl.AdmArticletypeServiceImpl;

public class AdmArticletypeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmArticletypeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findArticletype".equals(action)){
			List<Articletype> list = new ArrayList<Articletype>();
			HttpSession s = req.getSession();
			AdmArticletypeService admArticletypeService = new AdmArticletypeServiceImpl();
			list = admArticletypeService.findArticletype();
			s.setAttribute("articletypeList", list);
			resp.sendRedirect("articletype_management.jsp");
		}if("deleteArticletype".equals(action)){
			int atid = Integer.parseInt(req.getParameter("atid"));
			System.out.println("id测试"+atid);
			AdmArticletypeService admArticletypeService = new AdmArticletypeServiceImpl();
			boolean flag = admArticletypeService.deleteArticletype(atid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("admArticletypeServlet?action=findArticletype");
			}
			
		}if("addArticletype".equals(action)){
			System.out.println("jkajxkhk");
			//int atid= Integer.parseInt(req.getParameter("atid"));
			String atype = req.getParameter("atype");
			Articletype articletype = new Articletype();
		//	articletype.setAtid(atid);
			articletype.setAtype(atype);
			AdmArticletypeService admArticletypeService = new AdmArticletypeServiceImpl();
			boolean flag = admArticletypeService.addArticletype(articletype);
			if(flag){
				resp.sendRedirect("admArticletypeServlet?action=findArticletype");
			}else{
				resp.sendRedirect("articletype_management_add.jsp");
			}
		}if("updateArticletype".equals(action)){
			System.out.println("进入更新。。。。");
		
		
			AdmArticletypeService admArticletypeService = new AdmArticletypeServiceImpl();
			int atid= Integer.parseInt(req.getParameter("atid"));
			String atype = req.getParameter("atype");
			Articletype articletype = new Articletype();
			articletype.setAtid(atid);
			articletype.setAtype(atype);
			boolean flag = admArticletypeService.updateArticletype(articletype);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admArticletypeServlet?action=findArticletype");
			}else{
				JOptionPane.showMessageDialog(null, "更新文章类型失败");
			}
		}if("findupdateArticletype".equals(action)){
			int atid = Integer.parseInt(req.getParameter("atid").trim());
			System.out.print("===[[["+atid);
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmArticletypeService admArticletypeService = new AdmArticletypeServiceImpl();
			Articletype articletype = admArticletypeService.findArticletypeByid(atid);
			s.setAttribute("articletype", articletype);
			System.out.print("==="+articletype.getAtid());
			//resp.sendRedirect(req.getContextPath()+"articletype_management_update.jsp");
			resp.sendRedirect("articletype_management_update.jsp");
		}
	}

}
