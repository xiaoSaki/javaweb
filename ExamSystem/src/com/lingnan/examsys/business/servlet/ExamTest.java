package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.service.AnswerService;
import com.lingnan.examsys.business.service.AnswerServiceImpl;
import com.lingnan.examsys.business.service.ExaminationService;
import com.lingnan.examsys.business.service.ExaminationServiceImpl;
import com.lingnan.examsys.business.service.Quetion_bankService;
import com.lingnan.examsys.business.service.Quetion_bankServiceImpl;
import com.lingnan.examsys.business.service.RecordService;
import com.lingnan.examsys.business.service.RecordServiceImpl;

/**
 * Servlet implementation class Exam
 */
@WebServlet("/students/stu_test_exam")
public class ExamTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ExaminationService exam_serv = ExaminationServiceImpl.getInstance();
		AnswerService ans_serv = AnswerServiceImpl.getInstance();
		RecordService res_serv = RecordServiceImpl.getInstance();
		Quetion_bankService que_serv = Quetion_bankServiceImpl.getInstance();

		int exam_status = 0;																					//考试状态码：0-可用、1-不可用
		int answer_status = 0;																					//答题状态码：0-无答题、1-有未完成答题
		int exam_id = 0;
		ExaminationVO exam_vo = null;
		
		int user_id = (int) session.getAttribute("user_id");
		String continues_status_str = request.getParameter("continues");										//继续答题状态码
		int ans_id_exist = ans_serv.ifExistAnswering(user_id);													//是否有未完成答题id
		
		//获取请求测试exam_id
		if(request.getParameter("exam_id") != null) {
			exam_id = Integer.parseInt(request.getParameter("exam_id"));
		}else if(session.getAttribute("exam_id") != null){
			exam_id = (int) session.getAttribute("exam_id");
		}else {
			exam_status = 1;
		}
		//判断exam_id是否合法
		exam_vo = exam_serv.getExamById(exam_id);
		Timestamp nowtime = new Timestamp(System.currentTimeMillis());
		if(exam_vo == null | exam_vo.getUser_id() == 1 |(nowtime.before(exam_vo.getExam_begin()) | nowtime.after(exam_vo.getExam_end())))
			exam_status = 1;
		else
			session.setAttribute("exam_id", exam_id);				//保存请求测试的exam_id
		
		//若开始新的考试，结束旧答题;若存在未结束的答题则答题状态码为1
		if( continues_status_str !=null && continues_status_str.equals("0") ) {
			ans_serv.setEndtimeById(ans_id_exist, new Timestamp(System.currentTimeMillis()));
			ans_serv.setErrorsumById(ans_id_exist, 2);
		}
		else if(ans_id_exist != 0) 
			answer_status = 1;
		
		if( exam_status == 0 & answer_status == 0){
			//没有超时并且没有未完成答题或选择开始新答题
			//获取考试信息
			AnswerVO ans_vo = ans_serv.examTest(user_id, exam_id);
			int[] num = res_serv.createExamRecord(user_id, exam_id);
			Question_bankVO que_vo = que_serv.getQuetionById(num[0]);
			//更新request/session
			request.setAttribute("result", 0);
			request.setAttribute("exam_status", 0);																
			request.setAttribute("answer_status", 0);
			session.setAttribute("ans_id", ans_vo.getAns_id());
			session.setAttribute("ans_end", ans_vo.getAns_end());
			session.setAttribute("que_id", num[0]);
			session.setAttribute("test_name", exam_vo.getExam_name());
			session.setAttribute("num", num[1]);
			session.setAttribute("seq_num", 1);
			session.setAttribute("que_content",que_vo.getQue_content());
			session.setAttribute("que_type", que_vo.getQue_type());
			session.setAttribute("que_options", que_vo.getQue_options());
			session.setAttribute("que_url", que_vo.getQue_url());
			
			//response.sendRedirect("ExamTesting.jsp");
			request.getRequestDispatcher("ExamTesting.jsp").forward(request, response);
			
		}else {								
			//不在考试时间或考试有未完成的答题
			//更新session
			request.setAttribute("exam_status", exam_status);
			request.setAttribute("answer_status", answer_status);
			request.setAttribute("ans_id", ans_id_exist);
			request.getRequestDispatcher("ExamIndex.jsp").forward(request, response);
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
