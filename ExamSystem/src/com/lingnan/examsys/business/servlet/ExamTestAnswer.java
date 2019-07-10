package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.service.AnswerService;
import com.lingnan.examsys.business.service.AnswerServiceImpl;
import com.lingnan.examsys.business.service.Quetion_bankService;
import com.lingnan.examsys.business.service.Quetion_bankServiceImpl;
import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;
import com.lingnan.examsys.common.constant.MyType;

/**
 * Servlet implementation class ExamTestAnswer
 */
@WebServlet("/students/stu_test_exam_answer")
public class ExamTestAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamTestAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取答题相关信息
		HttpSession session = request.getSession();
		
		int user_id = (int) session.getAttribute("user_id");											//用户id
		int que_id = (int) session.getAttribute("que_id");												//题目id
		int ans_id = (int) session.getAttribute("ans_id");												//答题id
		int seq_num = (int) session.getAttribute("seq_num");											//答题题目顺序号
		int num = (int) session.getAttribute("num");													//答题题目总数
		String answer = request.getParameter("option");		
		
		Timestamp endtime = (Timestamp) session.getAttribute("ans_end");								//答题结束时间
		Timestamp nowtime = new Timestamp(System.currentTimeMillis());									//系统当前时间
		Timestamp vaildtime = new Timestamp(endtime.getTime());											//合法提交时间
		
		//定义执行对象
		Quetion_bankService que_serv = Quetion_bankServiceImpl.getInstance();
		AnswerService ans_serv = AnswerServiceImpl.getInstance();
		UserService user_serv = UserServiceImpl.getInstance();
		
		//超时判断
		if(nowtime.after(vaildtime)) {																	
			//答题超时
			request.setAttribute("result", -3);															//设置返回的判题状态码为超时（-3）
			user_serv.lockUserById(user_id, new Timestamp(nowtime.getTime()+MyType.EXAM_TEST_LUCK));	//封锁用户
			//更新答题信息
			ans_serv.setErrorsumById(ans_id, 2);
			//封锁
			session.setAttribute("supervalue", 0);
			session.removeAttribute("user_id");
			session.removeAttribute("ans_id");
			session.removeAttribute("ans_end");
			session.removeAttribute("test_name");
			session.removeAttribute("que_id");
			session.removeAttribute("seq_num");
			session.removeAttribute("que_type");
			session.removeAttribute("que_content");
			session.removeAttribute("que_options");
			session.removeAttribute("que_url");
			request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
			
		}else {																							
			//合法时间
			ans_serv.updateTimeOnRecordByAns_Id(ans_id, user_id, seq_num, nowtime);						//更新该题的答题记录的提交时间
			
			//对错判断
			if(que_serv.checkAnswer(que_id, answer)!=1){												
				//答案错误
				ans_serv.updateErrorflagOnRecordByAns_Id(ans_id, user_id, seq_num, 1);					//更新record表记录
				int error_sum = ans_serv.getAndPlusErrorsumById(ans_id);								//更新并获取answer表的错误次数
				
				//错误次数判断
				if(error_sum == 1) {																	
					//第一次错
					request.setAttribute("result", -1);	
					request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
					
				}else {																					
					//第二次错
					ans_serv.setEndtimeById(ans_id, nowtime);											//更新答题结束时间
					request.setAttribute("result", -2);													//设置返回的判题状态码为二次答错（-2）
					//封锁
					user_serv.lockUserById(user_id, new Timestamp(nowtime.getTime()+MyType.EXAM_TEST_LUCK));
					session.setAttribute("supervalue", 0);
					session.removeAttribute("user_id");
					session.removeAttribute("ans_id");
					session.removeAttribute("ans_end");
					session.removeAttribute("test_name");
					session.removeAttribute("que_id");
					session.removeAttribute("seq_num");
					session.removeAttribute("que_type");
					session.removeAttribute("que_content");
					session.removeAttribute("que_options");
					session.removeAttribute("que_url");
					request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
				}
			}else {
				
				//最后判断
				if(seq_num < num) {													//测试未完成
					request.setAttribute("result", 1);	
					//获取下一题
					int next_id = ans_serv.getNextQuetion(ans_id, user_id, seq_num);
					Question_bankVO que_vo = que_serv.getQuetionById(next_id);
					session.setAttribute("que_id", next_id);
					session.setAttribute("seq_num",seq_num+1);
					session.setAttribute("que_type", que_vo.getQue_type());
					session.setAttribute("que_content", que_vo.getQue_content());
					session.setAttribute("que_options", que_vo.getQue_options());;
					session.setAttribute("que_url", que_vo.getQue_url());
					request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
				}else {																					
					//测试完成
					ans_serv.setEndtimeById(ans_id, nowtime);
					ans_serv.updateMission(ans_id, user_id);
					request.setAttribute("result", 2);
					session.removeAttribute("ans_id");
					session.removeAttribute("ans_end");
					session.removeAttribute("test_name");
					session.removeAttribute("que_id");
					session.removeAttribute("seq_num");
					session.removeAttribute("que_type");
					session.removeAttribute("que_content");
					session.removeAttribute("que_options");
					session.removeAttribute("que_url");
					request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
				}
			}	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
