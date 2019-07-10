package com.neuedu.lvcity.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.BackstageService;
import com.neuedu.lvcity.service.impl.BackstageServiceImpl;

public class ScenicManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext sc;
	private String savePath;//服务器图片文件夹所在路径
	File file;

    public ScenicManageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	 public void init(ServletConfig config) {
		 // 在web.xml中设置的一个初始化参数
		 savePath = config.getInitParameter("savePath");//savePath为图片在xml配置上传到服务器的路径
		 sc = config.getServletContext();
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");	
		if("findScenic".equals(action)){
			List<Scenic> list = new ArrayList<Scenic>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findScenic();
			s.setAttribute("scenicList", list);
			resp.sendRedirect("scenic_management.jsp");
		}if("deleteScenic".equals(action)){
			int sid = Integer.parseInt(req.getParameter("sid"));
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.deleteScenic(sid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除scenic成功");
				resp.sendRedirect("scenicManageServlet?action=findScenic");
			}	
		}if("deleteCheckScenic".equals(action)){
			String[] arr1 = req.getParameterValues("arr");
			BackstageService backstageService = new BackstageServiceImpl();
			for(String a : arr1){
				String[] b = a.split(",");   //用","对数组a进行分割
				for(String c : b)
					backstageService.deleteScenic(Integer.parseInt(c));
			}
			resp.sendRedirect("scenicManageServlet?action=findScenic");
		}if("addScenic".equals(action)){
			int stid = 0;
			int aid = 0;
			String sname = null;
			String image = null;
			String lx = "景点";
			req.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(req);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("stid"))
		    	    		stid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("sname"))
							sname = item.getString("UTF-8");
						if(item.getFieldName().equals("aid"))
							aid = Integer.parseInt(item.getString("UTF-8"));						
					} else {
						if (item.getName() != null && !item.getName().equals("")) {
							File tempFile = new File(item.getName());
							String fileName = tempFile.getName();
							if (fileName != null && fileName.length() > 0) {
								// 取得扩展名
								String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
								// 上传图片,判断文件的后缀名是否为图片
								if (fileExtName.equalsIgnoreCase("jpeg")
										|| fileExtName.equalsIgnoreCase("png")
										|| fileExtName.equalsIgnoreCase("jpg")
										|| fileExtName.equalsIgnoreCase("gif")
										|| fileExtName.equalsIgnoreCase("ico")// 图标的后缀名
										|| fileExtName.equalsIgnoreCase("bmp")// Windows操作系统中的标准图像文件格式
								) {
									// 上传文件的保存路径
									file = new File(sc.getRealPath("/") + savePath,tempFile.getName());
									image=savePath+"/"+fileName;
									System.out.println("file测试"+file);
								}
							}
							item.write(file);
							req.setAttribute("upload.message", "上传文件成功！");
						} else {
							req.setAttribute("upload.message", "没有选择上传文件！");
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("upload.message", "上传文件失败！");
			}			
			Scenic scenic = new Scenic();
			scenic.setStid(stid);
			scenic.setSname(sname);
			scenic.setImage(image);
			scenic.setAid(aid);
			scenic.setLx(lx);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.addScenic(scenic);
			if(flag){
				resp.sendRedirect("scenicManageServlet?action=findScenic");
			}else{
				resp.sendRedirect("scenic_management_add.jsp");
			}			
		}if("findScenicLike".equals(action)){
			String stid = req.getParameter("stid");
			String sname = req.getParameter("sname");
			List<Scenic> list = new ArrayList<Scenic>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			if(stid != ""){
				list = backstageService.findScenic(Integer.parseInt(stid), sname);
			}else{
				list = backstageService.findScenic(sname);
			}
			System.out.println("stid的值"+stid);
			s.setAttribute("scenicList", list);
			resp.sendRedirect("scenic_management.jsp");
		}if("findUpdateScenic".equals(action)){			
			int sid = Integer.parseInt(req.getParameter("sid").trim());
			HttpSession s = req.getSession();
			List<Scenic> list = new ArrayList<Scenic>();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findUpdateScenic(sid);
			s.setAttribute("scenicList", list);
			resp.sendRedirect("scenic_management_update.jsp");
		}if("updateScenic".equals(action)){
			int sid = 0;
			int stid = 0;
			int aid = 0;
			String lx = "景点";
			String sname = null;
			String image = null;	
			req.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(req);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("sid"))
		    	    		sid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("image"))
							image = item.getString("UTF-8");
						if(item.getFieldName().equals("stid"))
		    	    		stid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("sname"))
							sname = item.getString("UTF-8");
						if(item.getFieldName().equals("aid"))
							aid = Integer.parseInt(item.getString("UTF-8"));						
					} else {
						if (item.getName() != null && !item.getName().equals("")) {
							File tempFile = new File(item.getName());
							String fileName = tempFile.getName();
							if (fileName != null && fileName.length() > 0) {
								// 取得扩展名
								String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
								// 上传图片,判断文件的后缀名是否为图片
								if (fileExtName.equalsIgnoreCase("jpeg")
										|| fileExtName.equalsIgnoreCase("png")
										|| fileExtName.equalsIgnoreCase("jpg")
										|| fileExtName.equalsIgnoreCase("gif")
										|| fileExtName.equalsIgnoreCase("ico")// 图标的后缀名
										|| fileExtName.equalsIgnoreCase("bmp")// Windows操作系统中的标准图像文件格式
								) {
									// 上传文件的保存路径
									file = new File(sc.getRealPath("/") + savePath,tempFile.getName());
									image=savePath+"/"+fileName;
									System.out.println("file测试"+file);
								}
							}
							item.write(file);
							req.setAttribute("upload.message", "上传文件成功！");
						} else {
							req.setAttribute("upload.message", "没有选择上传文件！");
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("upload.message", "上传文件失败！");
			}			
			Scenic scenic = new Scenic();
			scenic.setSid(sid);
			scenic.setStid(stid);
			scenic.setSname(sname);
			scenic.setImage(image);
			scenic.setAid(aid);
			scenic.setLx(lx);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.updateScenic(scenic);
			System.out.println("测试更新");
			if(flag){
				resp.sendRedirect("scenicManageServlet?action=findScenic");
			}else{
				resp.sendRedirect("scenic_management_update.jsp");
			}
		}
		
	}
}
