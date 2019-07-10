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

import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.service.AdmBanarService;
import com.neuedu.lvcity.service.impl.AdmBanarServiceImpl;

public class AdmBanarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AdmBanarServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("findBanar".equals(action)){
			List<Banar> list = new ArrayList<Banar>();
			HttpSession s = req.getSession();
			AdmBanarService admBanarService = new AdmBanarServiceImpl();
			list = admBanarService.findBanar();
			s.setAttribute("banarList", list);
			resp.sendRedirect("banar_management.jsp");
		}if("deleteBanar".equals(action)){
			int banarid = Integer.parseInt(req.getParameter("banarid"));
			System.out.println("id测试"+banarid);
			AdmBanarService admBanarService = new AdmBanarServiceImpl();
			boolean flag = admBanarService.deleteBanar(banarid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除用户成功");
				resp.sendRedirect("admBanarServlet?action=findBanar");
			}
			
		}if("addBanar".equals(action)){
			System.out.println("jkajxkhk");
			int state = Integer.parseInt(req.getParameter("state"));
			String image = req.getParameter("image");
			Banar banar = new Banar();
			banar.setImage(image);
			banar.setState(state);
			AdmBanarService admBanarService = new AdmBanarServiceImpl();
			boolean flag = admBanarService.addBanar(banar);
			if(flag){
				resp.sendRedirect("admBanarServlet?action=findBanar");
			}else{
				resp.sendRedirect("banar_management_add.jsp");
			}
		}if("updateBanar".equals(action)){
			System.out.println("进入更新。。。。");
		
		
			AdmBanarService admBanarService = new AdmBanarServiceImpl();
			int banarid= Integer.parseInt(req.getParameter("banarid"));
			int state = Integer.parseInt(req.getParameter("state"));
			String image = req.getParameter("image");
			Banar banar = new Banar();
			banar.setBanarid(banarid);
			banar.setImage(image);
			banar.setState(state);
			boolean flag = admBanarService.updateBanar(banar);
			System.out.print("gggg"+flag);
			if(flag){
				resp.sendRedirect("admBanarServlet?action=findBanar");
			}else{
				JOptionPane.showMessageDialog(null, "更新用户失败");
			}
		}if("findupdateBanar".equals(action)){
			int banarid = Integer.parseInt(req.getParameter("banarid").trim());
			
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession s = req.getSession();
			AdmBanarService admBanarService = new AdmBanarServiceImpl();
			Banar banar = admBanarService.findBanarByid(banarid);
			s.setAttribute("banar", banar);
			//resp.sendRedirect(req.getContextPath()+"banar_management_update.jsp");
			resp.sendRedirect("banar_management_update.jsp");
		}
	}

}
