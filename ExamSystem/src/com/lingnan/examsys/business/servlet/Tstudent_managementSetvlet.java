package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.lingnan.examsys.business.domain.AnnouncementVO;
import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.business.service.Stu_ClassService;
import com.lingnan.examsys.business.service.Stu_ClassServiceImpl;
import com.lingnan.examsys.business.service.Tstudent_managementService;
import com.lingnan.examsys.business.service.Tstudent_managementServiceImpl;
import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;

public class Tstudent_managementSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Tstudent_managementSetvlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");	
		if("showCl".equals(action)){
			resp.sendRedirect(req.getContextPath()+"/teachers/StudentManagement.jsp");
		}else if("showRank".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<RankingVO> Answer_rank = Tstudent_managementService.findStudentAnswerRank(user_id);
			se.setAttribute("Answer_rank",Answer_rank);
			resp.sendRedirect(req.getContextPath()+"/teachers/FindAllStudent.jsp");
			System.out.println("2完成");
		}else if("showStuAns".equals(action)){
			RankingVO user= new RankingVO();
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String user_name= new String(req.getParameter("user_name"));
			System.out.println("页面取值1"+user_id);
			System.out.println("页面取值2"+user_name);
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			HttpSession se = req.getSession();
			
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<Ans_RecordVO> Answer_record = Tstudent_managementService.findStudentAnswerRecord(user);		
			se.setAttribute("Answer_record",Answer_record);
			resp.sendRedirect(req.getContextPath()+"/teachers/QuestionsRecordList.jsp");
		}else if("showStuClass".equals(action)){
			resp.sendRedirect(req.getContextPath()+"/teachers/ClassManagement.jsp");
		}else if("showStuClass2".equals(action)){
			resp.sendRedirect(req.getContextPath()+"/teachers/Class_Management.jsp");
		}//班级列表
//		else if("showStuClassL".equals(action)){
//			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			HttpSession se = req.getSession();
//			// 调用Service方法
//			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
//			int pageNum=1;
//			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
//			se.setAttribute("ClassShow",ClassShow);
//			se.setAttribute("pageNum",pageNum);
//			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
//		}
		else if("showStuClassL".equals(action)){//首页班级显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum = 1;			
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);
			int pagesum =Tstudent_managementService.findmaxClass(user_id);
			System.out.println("测试:"+"分页查看题目");
			se.setAttribute("ClassShow",ClassShow);
			se.setAttribute("pageNum",pageNum);
			int pageCount;
			if(pagesum%5!=0){
				pageCount=pagesum/5+1;
				}
			else pageCount=pagesum/5;
			se.setAttribute("pageCount",pageCount);
			System.out.println("pageCount:"+pageCount);
			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			System.out.println("测试:"+"分页查看班级完成");
		}else if("showStuClassL1".equals(action)){//首页题库显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum =Integer.parseInt(req.getParameter("pageNum"));
			int pageCount =Integer.parseInt(req.getParameter("pageCount"));
			if(pageNum>=pageCount)pageNum=pageCount;
			if(pageNum<=1)pageNum=1;
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
			se.setAttribute("ClassShow",ClassShow);
			se.setAttribute("pageNum",pageNum);
			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			System.out.println("测试:"+"上下页查看班级完成");
		}
		else if("showStuClassL2".equals(action)){//首页班级显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum = 1;			
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);
			int pagesum =Tstudent_managementService.findmaxClass(user_id);
			System.out.println("测试:"+"分页查看题目");
			se.setAttribute("ClassShow",ClassShow);
			se.setAttribute("pageNum",pageNum);
			int pageCount;
			if(pagesum%5!=0){
				pageCount=pagesum/5+1;
				}
			else pageCount=pagesum/5;
			se.setAttribute("pageCount",pageCount);
			System.out.println("pageCount:"+pageCount);
			resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
			System.out.println("测试:"+"分页查看班级完成");
		}else if("showStuClassL22".equals(action)){//首页题库显示
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int pageNum =Integer.parseInt(req.getParameter("pageNum"));
			int pageCount =Integer.parseInt(req.getParameter("pageCount"));
			if(pageNum>=pageCount)pageNum=pageCount;
			if(pageNum<=1)pageNum=1;
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
			se.setAttribute("ClassShow",ClassShow);
			se.setAttribute("pageNum",pageNum);
			resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
			System.out.println("测试:"+"上下页查看班级完成");
		}
		//添加班级
		else if("insertTeaClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String class_name=new String(req.getParameter("class_name"));
			String class_name=req.getParameter("class_name");
			System.out.println("页面取值"+user_id+class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean cl_na =Tstudent_managementService.findClassByClassName(class_name);
			if(cl_na==true){
				boolean cl_id=Tstudent_managementService.findClassByClassid(class_name);
				if(cl_id==true){
					System.out.println("2进入"+user_id+class_name);
					JOptionPane.showMessageDialog(null, "您已经添加过该班级了");
					//显示该老师教的所有班级
					int pageNum=1;
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
					se.setAttribute("ClassShow",ClassShow);
					se.setAttribute("pageNum",pageNum);
					resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
				}
				else{
					System.out.println("3进入"+user_id+class_name);
					ClassVO classShow= Tstudent_managementService.findClassIdByClassname(class_name);
					int class_id=classShow.getClass_id();
					Tea_ClassVO tea_class=new Tea_ClassVO();
					System.out.println(class_name+class_id);
					tea_class.setUser_id(user_id);
					tea_class.setClass_id(class_id);
					
					boolean insert = Tstudent_managementService.insertClassByClassName(tea_class);
					if(insert==true){
						JOptionPane.showMessageDialog(null, "添加成功");
						
					//显示该老师教的所有班级
					int pageNum=1;
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
					se.setAttribute("ClassShow",ClassShow);
					se.setAttribute("pageNum",pageNum);
					resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
					}
					else{
						JOptionPane.showMessageDialog(null, "添加失败");
						resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
						
					}
					}
			}
			else
			{	
				System.out.println("4进入"+user_id+class_name);
					//在添加班级上面给出该老师还未添加过的班级。
				List<ClassVO> notClassShow = Tstudent_managementService.findNotClassByTeaId(user_id);		
				se.setAttribute("ClassShow",notClassShow);
				JOptionPane.showMessageDialog(null, "该班级不存在，以下是还未添加过的班级", "提示消息",JOptionPane.WARNING_MESSAGE);
				System.out.println("5进入"+user_id+class_name);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			}
		}else if("insertTeaClass2".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String class_name=new String(req.getParameter("class_name"));
			String class_name=req.getParameter("class_name");
			System.out.println("页面取值"+user_id+class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean cl_na =Tstudent_managementService.findClassByClassName(class_name);
			if(cl_na==true){
				boolean cl_id=Tstudent_managementService.findClassByClassid(class_name);
				if(cl_id==true){
					System.out.println("2进入"+user_id+class_name);
					JOptionPane.showMessageDialog(null, "您已经添加过该班级了");
					//显示该老师教的所有班级
					int pageNum=1;
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
					se.setAttribute("ClassShow",ClassShow);
					se.setAttribute("pageNum",pageNum);
					resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
				}
				else{
					System.out.println("3进入"+user_id+class_name);
					ClassVO classShow= Tstudent_managementService.findClassIdByClassname(class_name);
					int class_id=classShow.getClass_id();
					Tea_ClassVO tea_class=new Tea_ClassVO();
					System.out.println(class_name+class_id);
					tea_class.setUser_id(user_id);
					tea_class.setClass_id(class_id);
					
					boolean insert = Tstudent_managementService.insertClassByClassName(tea_class);
					if(insert==true){
						JOptionPane.showMessageDialog(null, "添加成功");
						
					//显示该老师教的所有班级
					int pageNum=1;
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
					se.setAttribute("ClassShow",ClassShow);
					se.setAttribute("pageNum",pageNum);
					resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
					}
					else{
						JOptionPane.showMessageDialog(null, "添加失败");
						resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
						
					}
					}
			}
			else
			{	
				System.out.println("4进入"+user_id+class_name);
					//在添加班级上面给出该老师还未添加过的班级。
				List<ClassVO> notClassShow = Tstudent_managementService.findNotClassByTeaId(user_id);		
				se.setAttribute("ClassShow",notClassShow);
				JOptionPane.showMessageDialog(null, "该班级不存在，以下是还未添加过的班级", "提示消息",JOptionPane.WARNING_MESSAGE);
				System.out.println("5进入"+user_id+class_name);
				resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
			}
		}//添加学生
		else if("insertTeaStuClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
//			String class_name=new String(req.getParameter("class_name"));
//			String class_name=req.getParameter("class_name");
			System.out.println("页面取值"+user_id+class_id);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			Stu_ClassService Stu_ClassService = new Stu_ClassServiceImpl();
			UserService UserService = new UserServiceImpl();
			
			//查找该学生是否已经存在
			boolean stu_na =Stu_ClassService.findStuClassByClassidAndUserid(user_id,class_id);
			//存在-提示该学生已经存在了
			if(stu_na==true){
					System.out.println("添加过");
					JOptionPane.showMessageDialog(null, "该学生已经存在了");
					//显示该班级所有学生
					List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
					se.setAttribute("allStudent",allStudent);
					resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
			}//不存在则查看是否有该学生-有则插入stu_class表，不存在则提示该学号不存在。
			else{
					System.out.println("没添加过"+user_id+class_id);
					//查看该学生是否存在user里
					
					boolean stu_in =UserService.findUserByUserid(user_id);
					if(stu_in==true){
						//插入stu_class表
						boolean insert = Stu_ClassService.insertStuClass(user_id,class_id);
						if(insert==true){
							JOptionPane.showMessageDialog(null, "添加成功");
							
							//显示该班级所有学生
							List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
							se.setAttribute("allStudent",allStudent);
							resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
						}
						else{
							JOptionPane.showMessageDialog(null, "添加失败");
							resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
							
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "该学生不存在");
						resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
						
					}
					}
			}//删除班级
		else if("deleteTeaClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=new String(req.getParameter("class_name"));
			ClassVO  classin=new ClassVO();
			classin.setClass_name(class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean dele = Tstudent_managementService.deleteTeaClass(classin);
			if(dele==true){
				int pageNum=1;
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
				se.setAttribute("ClassShow",ClassShow);
				se.setAttribute("pageNum",pageNum);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败");
				//显示该老师教的所有班级
				int pageNum=1;
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
				se.setAttribute("ClassShow",ClassShow);
				se.setAttribute("pageNum",pageNum);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			
			}
		}else if("deleteTeaClass2".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=new String(req.getParameter("class_name"));
			ClassVO  classin=new ClassVO();
			classin.setClass_name(class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean dele = Tstudent_managementService.deleteTeaClass(classin);
			if(dele==true){
				int pageNum=1;
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
				se.setAttribute("ClassShow",ClassShow);
				se.setAttribute("pageNum",pageNum);
				resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败");
				//显示该老师教的所有班级
				int pageNum=1;
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(pageNum, 5,user_id);		
				se.setAttribute("ClassShow",ClassShow);
				se.setAttribute("pageNum",pageNum);
				resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
			
			}
		}//删除学生
		else if("deleteStu".equals(action)){
			
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			System.out.println("删除学生"+user_id+"  "+class_id);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			Stu_ClassService Stu_classService = new Stu_ClassServiceImpl();
			boolean dele = Stu_classService.deleteStuByUserID(user_id);
			if(dele==true){
				//班级所有学生
				List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
				se.setAttribute("allStudent",allStudent);
				resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败");
				//班级所有学生
				List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
				se.setAttribute("allStudent",allStudent);
				resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
			
			}
		}//搜索框搜索班级
		else if("findClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=req.getParameter("class_name");
//			String class_name=new String(req.getParameter("class_name"));
			System.out.println("页面取值："+user_id+class_name);
			
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaIdAndCn(user_id, class_name);	
			se.setAttribute("ClassShow",ClassShow);
			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
		
		}else if("findClass2".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=req.getParameter("class_name");
//			String class_name=new String(req.getParameter("class_name"));
			System.out.println("页面取值："+user_id+class_name);
			
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaIdAndCn(user_id, class_name);	
			se.setAttribute("ClassShow",ClassShow);
			resp.sendRedirect(req.getContextPath()+"/teachers/ManagementList.jsp");
		
		}//查找学生
		else if("findStu".equals(action)){
			//String find_name=new String(req.getParameter("find_name"));
			String find_name=req.getParameter("find_name");
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			System.out.println("页面取值："+find_name+"  "+class_id);
			HttpSession se = req.getSession();
			// 调用Service方法
			
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<UserVO> findname = Tstudent_managementService.findStuByNameAndClassID(find_name,class_id);
//			if(findname==null)
//			{			
//			List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
//			se.setAttribute("allStudent",allStudent);
//			resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
//			}
//			else{
			System.out.println("findname "+findname);
				se.setAttribute("allStudent",findname);
				resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
//			}
		
		}
		//查看班级情况
		else if("particulars".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			String class_name=new String(req.getParameter("class_name"));
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			//统计班级总人数
			int stu_Cnum =Tstudent_managementService.findSTNumberByCn(class_name);
			se.setAttribute("stu_Cnum",stu_Cnum);
			//查找试卷
			List<ExaminationVO> findExamination =Tstudent_managementService.findExamByUid(user_id,class_name);
			se.setAttribute("findExamination",findExamination);
			
			se.setAttribute("class_id",class_id);
			System.out.println("haha2222"+stu_Cnum);
			resp.sendRedirect(req.getContextPath()+"/teachers/ClassCompletion.jsp");
		
		}else if("findStuStatus".equals(action)){
			int exam_id =Integer.parseInt(req.getParameter("exam_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			int fnum =Integer.parseInt(req.getParameter("fnum"));
			int anum =Integer.parseInt(req.getParameter("anum"));
			System.out.println("hah"+exam_id+"   hhh"+class_id+"  fnum   "+fnum+" anum "+anum);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			se.setAttribute("fnum",fnum);//完成人数
			se.setAttribute("anum",anum);//班级总人数
			//查找试卷
			List<StuFinishStatusVO> StuFinishStatus=Tstudent_managementService.findStuStatus(exam_id);
			se.setAttribute("StuFinishStatus",StuFinishStatus);
			resp.sendRedirect(req.getContextPath()+"/teachers/TestCase.jsp");
		
		}//查看班级学生
		else if("findStuStatus2".equals(action)){
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String class_name=new String(req.getParameter("class_name"));
			System.out.println("   hhh"+class_id);
			int cid = class_id;
			HttpSession se = req.getSession();
			se.setAttribute("class_id",cid);
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			//统计班级总人数
			int stu_Cnum =Tstudent_managementService.findSTNumberByCn(class_name);
			se.setAttribute("stu_Cnum",stu_Cnum);
			//班级所有学生
			List<UserVO> allStudent =Tstudent_managementService.findStudentByClassId(class_id);
			se.setAttribute("allStudent",allStudent);
			
			resp.sendRedirect(req.getContextPath()+"/teachers/ClassTestCase.jsp");
		
		}else if("showUser".equals(action)){
			
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String user_name=new String(req.getParameter("user_name"));
			String user_pwd=new String(req.getParameter("user_pwd"));
			System.out.println("   hhh"+user_id+"  "+user_name+"   "+user_pwd);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			se.setAttribute("user_id",user_id);
			se.setAttribute("user_name",user_name);
			se.setAttribute("user_pwd",user_pwd);
			resp.sendRedirect(req.getContextPath()+"/teachers/UserTestCase.jsp");
		
		}//修改密码
		else if("updateUserPwd".equals(action)){
			//String user_pwd=new String(req.getParameter("user_pwd"));
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String user_name=new String(req.getParameter("user_name"));
			String user_pwd=req.getParameter("user_pwd");
			System.out.println("   hhh"+user_id+"  "+user_name+"   "+user_pwd);
			HttpSession se = req.getSession();
			UserService UserService = new UserServiceImpl();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			boolean updatePwd = UserService.UpdatePwd(user_pwd);
			if(updatePwd==true){
				JOptionPane.showMessageDialog(null, "修该成功");
				se.setAttribute("user_id",user_id);
				se.setAttribute("user_name",user_name);
				se.setAttribute("user_pwd",user_pwd);
				
				UserVO user=new UserVO();
		        user.setUser_id(user_id);
		        user.setUser_pwd(user_pwd);;
				List<UserVO> UserList = UserService.findUserByIdAndPassword(user);
				se.setAttribute("UserList",UserList);			
				resp.sendRedirect(req.getContextPath()+"/teachers/UserTestCase.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "修该失败");
				resp.sendRedirect(req.getContextPath()+"/teachers/UserTestCase.jsp");
			}

		}//公告
		else if("showAnnouncement".equals(action)){
			//String user_pwd=new String(req.getParameter("user_pwd"));
//			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String user_pwd=req.getParameter("user_pwd");
			String user_name=new String(req.getParameter("user_name"));
			System.out.println("username："+user_name);
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<AnnouncementVO> Announcement = Tstudent_managementService.findAnnouncement(user_name);
			se.setAttribute("Announcement",Announcement);
			//resp.sendRedirect(req.getContextPath()+"/teachers/AnnouncementTestCase.jsp");
			resp.sendRedirect("AnnouncementTestCase.jsp");

		}//添加公告
		else if("insertAnnouncement".equals(action)){
			//String user_pwd=new String(req.getParameter("user_pwd"));
//			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String user_pwd=req.getParameter("user_pwd");
			String text=req.getParameter("Text2");
			String user_name=new String(req.getParameter("user_name"));
			System.out.println("   hhh"+text+"  "+user_name);
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			boolean insertAnn = Tstudent_managementService.insertAnnouncement(text,user_name);
			if(insertAnn==true){
				JOptionPane.showMessageDialog(null, "插入成功");
				List<AnnouncementVO> Announcement = Tstudent_managementService.findAnnouncement(user_name);
				se.setAttribute("Announcement",Announcement);
				resp.sendRedirect(req.getContextPath()+"/teachers/manage_students.jsp");
			}else{
				JOptionPane.showMessageDialog(null, "插入失败");
				List<AnnouncementVO> Announcement = Tstudent_managementService.findAnnouncement(user_name);
				se.setAttribute("Announcement",Announcement);
				resp.sendRedirect(req.getContextPath()+"/teachers/manage_students.jsp");

			}
			
		}
		//删除公告
		else if("deleteAnnouncement".equals(action)){
			//String user_pwd=new String(req.getParameter("user_pwd"));
//			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String user_pwd=req.getParameter("user_pwd");
			int announcement_id =Integer.parseInt(req.getParameter("announcement_id"));
			String user_name=new String(req.getParameter("user_name"));
			
			System.out.println("   hhh"+announcement_id);
			HttpSession se = req.getSession();
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			boolean deleteAnn = Tstudent_managementService.deleteAnnouncement(announcement_id);
			if(deleteAnn==true){
				JOptionPane.showMessageDialog(null, "删除成功");
				List<AnnouncementVO> Announcement = Tstudent_managementService.findAnnouncement(user_name);
				se.setAttribute("Announcement",Announcement);
				resp.sendRedirect(req.getContextPath()+"/teachers/AnnouncementTestCase.jsp");
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
				List<AnnouncementVO> Announcement = Tstudent_managementService.findAnnouncement(user_name);
				se.setAttribute("Announcement",Announcement);
				resp.sendRedirect(req.getContextPath()+"/teachers/AnnouncementTestCase.jsp");

			}
			
		}
//			resp.setContentType("/teacher/manage_students.jsp");
	}
}
