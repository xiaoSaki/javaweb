package com.lingnan.examsys.business.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.service.ExaminationService;
import com.lingnan.examsys.business.service.ExaminationServiceImpl;
import com.lingnan.examsys.business.service.Question_bankService;
import com.lingnan.examsys.business.service.Question_bankServiceImpl;

public class Question_bankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Question_bankServlet(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	//2018/10/27 mai
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String action = req.getParameter("action");	
		//试卷管理
		if("showEM".equals(action)){//试卷管理
			resp.sendRedirect(req.getContextPath()+"/teachers/ExamManagement.jsp");
		}else if("showExam".equals(action)){//试卷显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			HttpSession se = req.getSession();
			// 调用Service方法
			ExaminationService examinationService = new ExaminationServiceImpl();
			List<ExaminationVO> examinationVO = examinationService.findExamByid(user_id);
			se.setAttribute("examinationVO",examinationVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExam.jsp");
			System.out.println("测试:"+"查看试卷完成");
		}else if("findExamByName".equals(action)){//搜索框查询试卷（试卷名模糊查询）
			int user_id = Integer.parseInt(req.getParameter("user_id"));
			String exam_name = req.getParameter("exam_name");
			System.out.println("页面取值："+exam_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			ExaminationService examinationService = new ExaminationServiceImpl();
			List<ExaminationVO> examinationVO = examinationService.findExamByName(user_id, exam_name);
			se.setAttribute("examinationVO",examinationVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExam.jsp");
			System.out.println("测试:"+"搜索框查询试卷完成");
		}else if("findQueByexam_id".equals(action)){//根据试卷id查看试题id && 查看试卷试题详情
			int user_id = Integer.parseInt(req.getParameter("user_id"));
			int exam_id = Integer.parseInt(req.getParameter("exam_id"));
			List<Question_bankVO> que_bankVO = null;
			HttpSession se = req.getSession();
			ExaminationService examinationService = new ExaminationServiceImpl();	
			List<Que_ExamVO> Que_ExamVO = examinationService.findQueByexam_id(exam_id);
			int i=0;
			int[] a=new int[50];
			for (Que_ExamVO qe : Que_ExamVO) {	
				a[i]= qe.getQue_id();
				i++;
			}
			que_bankVO = examinationService.findQueByque_id(a);
			se.setAttribute("exam_id", exam_id);
			se.setAttribute("Que_bankVO",que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExamContent.jsp");
			System.out.println("测试:"+"根据试卷id查看试题id完成");
		}else if("delExam_Que".equals(action)){//查看试卷详情时删除题目
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int exam_id = Integer.parseInt(req.getParameter("exam_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
			System.out.println("ceshi:"+user_id+" "+exam_id+" "+que_id);
			ExaminationService examinationService = new ExaminationServiceImpl();
			boolean flag = examinationService.delExam_Que(exam_id, que_id);
			System.out.println("servlet测试:"+flag);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除题目成功");
			}else{
				JOptionPane.showMessageDialog(null, "删除题目失败");
			}
			List<Question_bankVO> que_bankVO = null;
			HttpSession se = req.getSession();
			List<Que_ExamVO> Que_ExamVO = examinationService.findQueByexam_id(exam_id);
			int i=0;
			int[] a=new int[50];
			for (Que_ExamVO qe : Que_ExamVO) {	
				a[i]= qe.getQue_id();
				i++;
			}
			que_bankVO = examinationService.findQueByque_id(a);
			se.setAttribute("exam_id", exam_id);
			se.setAttribute("Que_bankVO",que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExamContent.jsp");		
		}else if("findUpdateQue".equals(action)){
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession se = req.getSession();
			ExaminationService examinationService = new ExaminationServiceImpl();
			List<Question_bankVO> Que_bankVO = examinationService.findQueByid(que_id);
			se.setAttribute("Que_bankVO", Que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/updateQue.jsp");
		}else if("updateExam_Que".equals(action)){
			HttpSession se = req.getSession();
			Question_bankVO Que_bankVO = new Question_bankVO();
			ExaminationService examinationService = new ExaminationServiceImpl();
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
			int exam_id = Integer.parseInt(req.getParameter("exam_id").trim());
			int Que_charpter = Integer.parseInt(req.getParameter("que_charpter").trim());
			String Que_type = req.getParameter("que_type");
		    String Que_content = new String(req.getParameter("que_content"));
		    String Que_options = new String(req.getParameter("que_options"));
		    String Que_answer = new String(req.getParameter("que_answer"));
		    System.out.println(exam_id+" "+que_id+" "+Que_charpter+" "+Que_type+" "+Que_content+" "+Que_options+" "+Que_answer);
		    Que_bankVO.setUser_id(user_id);
		    Que_bankVO.setQue_id(que_id);
		    Que_bankVO.setQue_charpter(Que_charpter);
		    Que_bankVO.setQue_type(Que_type);
		    Que_bankVO.setQue_content(Que_content);
		    Que_bankVO.setQue_options(Que_options);
		    Que_bankVO.setQue_answer(Que_answer);	
			boolean flag = examinationService.updateQue_bank(Que_bankVO);
			if(flag){
				JOptionPane.showMessageDialog(null, "更新题目成功");
			}else{
				JOptionPane.showMessageDialog(null, "更新题目失败");
			}	
			List<Question_bankVO> que_bankVO = null;
			List<Que_ExamVO> Que_ExamVO = examinationService.findQueByexam_id(exam_id);
			int i=0;
			int[] a=new int[50];
			for (Que_ExamVO qe : Que_ExamVO) {	
				a[i]= qe.getQue_id();
				i++;
			}
			que_bankVO = examinationService.findQueByque_id(a);
			se.setAttribute("exam_id", exam_id);
			se.setAttribute("Que_bankVO",que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExamContent.jsp");
		}else if("insertExam".equals(action)){
			int user_id = Integer.parseInt(req.getParameter("user_id"));
			String exam_name = req.getParameter("exam_name");
			Date exam_begin = null;
	        Date exam_end = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				exam_begin = sdf.parse(req.getParameter("exam_begin"));
				exam_end = sdf.parse(req.getParameter("exam_end"));
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("字符串转换成日期失败");
			}
			HttpSession se = req.getSession();
			ExaminationService examinationService = new ExaminationServiceImpl();
			int exam_id = examinationService.insertExam(user_id, exam_name, exam_begin, exam_end);
			System.out.println("servlet exam_id测试:"+exam_id);
			se.setAttribute("exam_id",exam_id);
			int pageNum = 1;
			Question_bankService QBService = new Question_bankServiceImpl();
			List<Question_bankVO> Que_bankVO = QBService.findAllQuestion_bank(pageNum, 5,user_id);
			se.setAttribute("Que_bankVO",Que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
			System.out.println("测试:"+"添加试卷成功");
		}else if("insertQue_Exam".equals(action)) {
			int user_id = Integer.parseInt(req.getParameter("user_id"));
			ExaminationService examinationService = new ExaminationServiceImpl();
			int exam_id = Integer.parseInt(req.getParameter("exam_id"));
			System.out.println("测试servlet："+user_id+exam_id);
			String[] arr = req.getParameterValues("arr");
			for(String a : arr){
				String[] b = a.split(",");   //用","对数组a进行分割
				for(String c : b){
					int que_id = Integer.parseInt(c);
					System.out.println("测试que_id："+que_id);
					examinationService.insertQueByid(exam_id,que_id);
				}				
				    
			}
			HttpSession se = req.getSession();
			List<ExaminationVO> examinationVO = examinationService.findExamByid(user_id);
			se.setAttribute("examinationVO",examinationVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExam.jsp");
			System.out.println("测试:"+"题库添加试卷试题");
		}else if("delExamByid".equals(action)){  //删除试卷 add 2018/11/17
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int exam_id = Integer.parseInt(req.getParameter("exam_id").trim());
//			System.out.println("ceshi:"+user_id+" "+exam_id);
			ExaminationService examinationService = new ExaminationServiceImpl();
			examinationService.delQue_ExamByid(exam_id);
			boolean flag = examinationService.delExamByid(exam_id);
			System.out.println("servlet测试:"+flag);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除试卷成功");
			}else{
				JOptionPane.showMessageDialog(null, "删除试卷失败");
			}
			HttpSession se = req.getSession();
			List<ExaminationVO> examinationVO = examinationService.findExamByid(user_id);
			se.setAttribute("examinationVO",examinationVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExam.jsp");
			System.out.println("测试:"+"删除试卷成功");			
		}else if("findUpdateExam".equals(action)){  //查找需要修改的试卷 add 2018/11/17
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int exam_id = Integer.parseInt(req.getParameter("exam_id").trim());
			HttpSession se = req.getSession();
			se.setAttribute("exam_id", exam_id);
			System.out.println("测试aaaaaaaaaa:"+exam_id);		
			ExaminationService examinationService = new ExaminationServiceImpl();
			List<ExaminationVO> ExamVO = examinationService.findExamByexam_id(exam_id);
			se.setAttribute("ExamVO", ExamVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/updateExam.jsp");
		}else if("updateExam".equals(action)){
			HttpSession se = req.getSession();
			ExaminationVO ExamVO = new ExaminationVO();
			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
			ExaminationService examinationService = new ExaminationServiceImpl();
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int exam_id = Integer.parseInt(req.getParameter("exam_id"));
			String exam_name = req.getParameter("exam_name");
//			Timestamp exam_begin = null;
//			Date exam_end = null;

//			String exam_begin = dft.format(req.getParameter("exam_begin"));
			Timestamp exam_begin2 = Timestamp.valueOf(req.getParameter("exam_begin"));
//			String exam_end = dft.format(req.getParameter("exam_end"));
			Timestamp exam_end2 = Timestamp.valueOf(req.getParameter("exam_end"));		
			ExamVO.setUser_id(user_id);
			ExamVO.setExam_id(exam_id);
			ExamVO.setExam_name(exam_name);
			ExamVO.setExam_begin(exam_begin2);
			ExamVO.setExam_end(exam_end2);
			boolean flag = examinationService.updateExam(ExamVO);
			if(flag){
				JOptionPane.showMessageDialog(null, "更新试卷成功");
			}else{
				JOptionPane.showMessageDialog(null, "更新试卷失败");
			}	
			List<ExaminationVO> examinationVO = examinationService.findExamByid(user_id);
			se.setAttribute("examinationVO",examinationVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/findExam.jsp");
			System.out.println("测试:"+"更新试卷成功");	
		}else if("findUpdateQue_bank".equals(action)){
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
//			System.out.println("测试aaaaaaaaaa:"+que_id);
			HttpSession se = req.getSession();
			ExaminationService examinationService = new ExaminationServiceImpl();
			List<Question_bankVO> Que_bankVO = examinationService.findQueByid(que_id);
			se.setAttribute("Que_bankVO", Que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/updateQue_bank.jsp");
		}else if("updateQue".equals(action)){
			HttpSession se = req.getSession();
			Question_bankVO Que_bankVO = new Question_bankVO();
			ExaminationService examinationService = new ExaminationServiceImpl();
			System.out.println("输出"+req.getParameter("exam_id"));
			
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
//			int exam_id = Integer.parseInt(req.getParameter("exam_id").trim());
			int Que_charpter = Integer.parseInt(req.getParameter("que_charpter").trim());
			String Que_type = req.getParameter("que_type");
		    String Que_content = new String(req.getParameter("que_content"));
		    String Que_options = new String(req.getParameter("que_options"));
		    String Que_answer = new String(req.getParameter("que_answer"));
		    System.out.println(" "+que_id+" "+Que_charpter+" "+Que_type+" "+Que_content+" "+Que_options+" "+Que_answer);
		    Que_bankVO.setUser_id(user_id);
		    Que_bankVO.setQue_id(que_id);
		    Que_bankVO.setQue_charpter(Que_charpter);
		    Que_bankVO.setQue_type(Que_type);
		    Que_bankVO.setQue_content(Que_content);
		    Que_bankVO.setQue_options(Que_options);
		    Que_bankVO.setQue_answer(Que_answer);	
			boolean flag = examinationService.updateQue_bank(Que_bankVO);
			if(flag){
				JOptionPane.showMessageDialog(null, "更新题目成功");
			}else{
				JOptionPane.showMessageDialog(null, "更新题目失败");
			}
			int pageNum = 1;
			Question_bankService QBService = new Question_bankServiceImpl();
//     		HttpSession se = req.getSession();
			List<Question_bankVO> que_bankVO = QBService.findAllQuestion_bank(pageNum, 10,user_id);
			se.setAttribute("Que_bankVO",que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
		}
		
		
		//题库管理
		else if("showQB".equals(action)){//题库管理
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bankManagement.jsp");
		}else if("showQue_bank".equals(action)){//首页题库显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum = 1;			
			HttpSession se = req.getSession();
			Question_bankService QBService = new Question_bankServiceImpl();
			List<Question_bankVO> Que_bankVO = QBService.findAllQuestion_bank(pageNum, 5,user_id);
			int pagesum =QBService.maxQuestion(user_id);
			System.out.println("测试:"+"分页查看题目");
			se.setAttribute("Que_bankVO",Que_bankVO);
			se.setAttribute("pageNum",pageNum);
			int pageCount;
			if(pagesum%5!=0){
				pageCount=pagesum/5+1;
				}
			else pageCount=pagesum/5;
			se.setAttribute("pageCount",pageCount);
			System.out.println("pageCount:"+pageCount);
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
			System.out.println("测试:"+"分页查看题目完成");
		}else if("showQue_bank2".equals(action)){//首页题库显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum =Integer.parseInt(req.getParameter("pageNum"));
			int pageCount =Integer.parseInt(req.getParameter("pageCount"));
			if(pageNum>=pageCount)pageNum=pageCount;
			if(pageNum<=1)pageNum=1;
			HttpSession se = req.getSession();
			Question_bankService QBService = new Question_bankServiceImpl();
			List<Question_bankVO> Que_bankVO = QBService.findAllQuestion_bank(pageNum, 5,user_id);
			se.setAttribute("Que_bankVO",Que_bankVO);
			se.setAttribute("pageNum",pageNum);
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
			System.out.println("测试:"+"上下页查看题目完成");
		}
		else if("findQue_bank".equals(action)){//搜索框查询试题（试题内容模糊查询，试题类型下拉框选择）
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String Que_content = req.getParameter("Que_content");
			String Que_type = req.getParameter("Que_type");
			System.out.println("ceshi:"+Que_content+" "+Que_type);
			if(!Que_content.equals("null") && Que_type.equals("null")){
				HttpSession se = req.getSession();
				Question_bankService QBService = new Question_bankServiceImpl();
				List<Question_bankVO> Que_bankVO = QBService.findQuestion_bankByContent(Que_content);
				se.setAttribute("Que_bankVO",Que_bankVO);
				resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
				System.out.println("测试:"+"1");
			}
			else if(!Que_content.equals("null") && !Que_type.equals("null")){
				HttpSession se = req.getSession();
				Question_bankService QBService = new Question_bankServiceImpl();
				List<Question_bankVO> Que_bankVO = QBService.findQuestion_bankByContentAndType(Que_content, Que_type);
				se.setAttribute("Que_bankVO",Que_bankVO);
				resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
				System.out.println("测试:"+"3");
			}
		}
		else if("insertQue".equals(action)){//教师添加试题
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			HttpSession se = req.getSession();
			Question_bankVO qbVO = new Question_bankVO();
		    int Que_chapter = Integer.parseInt(req.getParameter("Que_chapter"));
		    String Que_type = req.getParameter("Que_type");
		    String Que_content = req.getParameter("Que_content");
		    String Que_options = req.getParameter("Que_options");
		    String Que_answer = req.getParameter("Que_answer");
    	    System.out.println("ceshiinsert:"+Que_chapter+" "+Que_type);
		    if(Que_options == null){  //上传图片
		    	FileItemFactory factory = new DiskFileItemFactory();			 
		         // 创建文件上传处理器
		         ServletFileUpload upload = new ServletFileUpload(factory);		 
		         // 开始解析请求信息
		         List items = null;
		         try {
		             items = upload.parseRequest(req);
		         }
		         catch (FileUploadException e) {
		             e.printStackTrace();
		         }		 
		         // 对所有请求信息进行判断
		         Iterator iter = items.iterator();
		         while (iter.hasNext()) {
		             FileItem item = (FileItem) iter.next();
		             // 信息为普通的格式
		             if (item.isFormField()) {
		                 String fieldName = item.getFieldName();
		                 String value = item.getString();
		                 req.setAttribute(fieldName, value);
		             }
		             // 信息为文件格式
		             else {
		                 String fileName = item.getName();
		                 System.out.println(fileName);
		                 int index = fileName.lastIndexOf("\\");
		                 fileName = fileName.substring(index + 1);
		                 req.setAttribute("realFileName", fileName);		 
//		                 String basePath = req.getSession().getServletContext().getRealPath("/");  //获取绝对路径
		                 String basePath = req.getSession().getServletContext().getRealPath("/");  //获取绝对路径
		                 File file = new File(basePath, fileName);
		                 try {
		                     item.write(file);
		                 }
		                 catch (Exception e) {
		                     e.printStackTrace();
		                 }
		             }
		             req.setAttribute("pic_ifo","文件上传成功!");
		             getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		             }
		         Que_options = req.getParameter("file");
		    }
			     System.out.println(Que_content);
			     qbVO.setUser_id(user_id);
				 qbVO.setQue_charpter(Que_chapter);
				 qbVO.setQue_type(Que_type);
				 qbVO.setQue_content(Que_content);
				 qbVO.setQue_options(Que_options);
				 qbVO.setQue_answer(Que_answer);		
				 Question_bankService QBService = new Question_bankServiceImpl();
				 boolean flag = QBService.insertQuestion(qbVO);
				 if(flag){
					JOptionPane.showMessageDialog(null, "添加题目成功");
					int pageNum = 1;
					List<Question_bankVO> Que_bankVO = QBService.findAllQuestion_bank(user_id,pageNum, 5);
					se.setAttribute("Que_bankVO",Que_bankVO);
					resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
					System.out.println("测试:"+"添加题目完成");
				 }else{
					JOptionPane.showMessageDialog(null, "添加题目失败");
				 }					
		}else if("delQueByque_id".equals(action)){
			int user_id = Integer.parseInt(req.getParameter("user_id").trim());
			int que_id = Integer.parseInt(req.getParameter("que_id").trim());
			System.out.println("ceshi:"+user_id+" "+que_id);
			Question_bankService QBService = new Question_bankServiceImpl();
			QBService.delQue_Exam(que_id);
			boolean flag = QBService.delQueByque_id(que_id);
			System.out.println("servlet测试:"+flag);
			if(flag){
				JOptionPane.showMessageDialog(null, "删除试题成功");
			}else{
				JOptionPane.showMessageDialog(null, "删除试题失败");
			}
			int pageNum = 1;
     		HttpSession se = req.getSession();
			List<Question_bankVO> Que_bankVO = QBService.findAllQuestion_bank(pageNum, 10,user_id);
			se.setAttribute("Que_bankVO",Que_bankVO);
			resp.sendRedirect(req.getContextPath()+"/teachers/Que_bank.jsp");
			System.out.println("测试:"+"删除试题成功");	
		}	
	}
}
