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
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.BackstageService;
import com.neuedu.lvcity.service.impl.BackstageServiceImpl;

public class FoodManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext sc;
	private String savePath;//服务器图片文件夹所在路径
	File file;

    public FoodManageServlet() {
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
		if("findFood".equals(action)){
			List<Food> list = new ArrayList<Food>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findFood();
			s.setAttribute("foodList", list);
			resp.sendRedirect("food_management.jsp");
		}if("deleteFood".equals(action)){
			int fid = Integer.parseInt(req.getParameter("fid"));
			System.out.println("fid测试"+fid);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.deleteFood(fid);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除food成功");
				resp.sendRedirect("foodManageServlet?action=findFood");
			}	
		}if("deleteCheckFood".equals(action)){
			String[] arr1 = req.getParameterValues("arr");
			BackstageService backstageService = new BackstageServiceImpl();
			for(String a : arr1){
				String[] b = a.split(",");   //用","对数组a进行分割
				for(String c : b)
					backstageService.deleteFood(Integer.parseInt(c));
			}
			resp.sendRedirect("foodManageServlet?action=findFood");
		}if("addFood".equals(action)){
			int ftid = 0;
			int aid = 0;
			String fname = null;
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
						if(item.getFieldName().equals("ftid"))
		    	    		ftid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("fname"))
							fname = item.getString("UTF-8");
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
			Food food = new Food();
			food.setFtid(ftid);
			food.setFname(fname);
			food.setImage(image);
			food.setAid(aid);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.addFood(food);
			if(flag){
				resp.sendRedirect("foodManageServlet?action=findFood");
			}else{
				resp.sendRedirect("food_management_add.jsp");
			}			
		}if("findFoodLike".equals(action)){
			System.out.println("模糊查询测试");
			String ftid = req.getParameter("ftid");
			String fname = req.getParameter("fname");
			System.out.println(fname);
			System.out.println(ftid);
			List<Food> list = new ArrayList<Food>();
			HttpSession s = req.getSession();
			BackstageService backstageService = new BackstageServiceImpl();
			if(ftid != ""){
				list = backstageService.findFood(Integer.parseInt(ftid), fname);
			}else{
				list = backstageService.findFood(fname);
			}
			System.out.println("ftid的值"+ftid);
			s.setAttribute("foodList", list);
			resp.sendRedirect("food_management.jsp");
		}if("findUpdateFood".equals(action)){			
			int fid = Integer.parseInt(req.getParameter("fid").trim());
			HttpSession s = req.getSession();
			List<Food> list = new ArrayList<Food>();
			BackstageService backstageService = new BackstageServiceImpl();
			list = backstageService.findUpdateFood(fid);
			s.setAttribute("foodList", list);
			resp.sendRedirect("food_management_update.jsp");
		}if("updateFood".equals(action)){
			int fid = 0;
			int ftid = 0;
			int aid = 0;
			String fname = null;
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
						if(item.getFieldName().equals("fid"))
		    	    		fid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("image"))
							image = item.getString("UTF-8");
						if(item.getFieldName().equals("ftid"))
		    	    		ftid = Integer.parseInt(item.getString("UTF-8"));
						if(item.getFieldName().equals("fname"))
							fname = item.getString("UTF-8");
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
			Food food = new Food();
			food.setFid(fid);
			food.setFtid(ftid);
			food.setFname(fname);
			food.setImage(image);
			food.setAid(aid);
			BackstageService backstageService = new BackstageServiceImpl();
			boolean flag = backstageService.updateFood(food);
			System.out.println("测试更新");
			if(flag){
				resp.sendRedirect("foodManageServlet?action=findFood");
			}else{
				resp.sendRedirect("food_management_update.jsp");
			}
		}
		
	}
		
}
