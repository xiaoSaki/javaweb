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
import com.lingnan.examsys.common.constant.MyType;

/**
 * Servlet implementation class ChapterTest
 */
@WebServlet(name = "ChapterTest_new", description = "章节测试Servlet：负责章节测试中的测试任务", urlPatterns = { "/students/stu_test_chapter" })
public class ChapterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AnswerService ans_serv = AnswerServiceImpl.getInstance();
		Quetion_bankService que_serv = Quetion_bankServiceImpl.getInstance();

		int chapter_status = 0;																					//考试状态码：0-可用、1-不可用
		int answer_status = 0;	
		int chapter = 0;

		int user_id = (int) session.getAttribute("user_id");
		String continues_status_str = request.getParameter("continues");										//继续答题状态码
		int ans_id_exist = ans_serv.ifExistAnswering(user_id);
		
		//获取请求测试的章节数
		if( request.getParameter("chapter") != null) {															//存储请求的章节数
			chapter = Integer.parseInt(request.getParameter("chapter"));
		}else if(session.getAttribute("chapter") != null){
			chapter = (int) session.getAttribute("chapter");
		}

		//判断章节数是否合法
		if(chapter>que_serv.getMaxChapterNum()) {
			chapter_status = 1;
		}else {
			session.setAttribute("chapter", chapter);									//保存请求测试的章节数
		}
		
		//若开始新的考试，结束旧答题;若存在未结束的答题则答题状态码为1
		if( continues_status_str !=null && continues_status_str.equals("0") ) {
			ans_serv.setEndtimeById(ans_id_exist, new Timestamp(System.currentTimeMillis()));
			ans_serv.setErrorsumById(ans_id_exist, 2);
		}
		else if(ans_id_exist != 0) 
			answer_status = 1;

		if( chapter_status == 0 & answer_status == 0){
			//没有超时并且没有未完成答题或选择开始新答题
			//获取考试信息
			AnswerVO ans_vo = ans_serv.chapterTest(user_id, chapter);
			RecordService rec_serv = new RecordServiceImpl();
			int que_id = rec_serv.createChapterTestRecord(user_id, ans_vo.getExam_id(), chapter);
			Question_bankVO que_vo = que_serv.getQuetionById(que_id);
			//设置session信息
			request.setAttribute("chapter_status", 0);		
			request.setAttribute("answer_status", 0);
			request.setAttribute("result", 0);
			session.setAttribute("test_name", MyType.ChapterTestName(chapter));
			session.setAttribute("ans_id", ans_vo.getAns_id());
			session.setAttribute("ans_end", ans_vo.getAns_end());
			session.setAttribute("que_id", que_id);
			session.setAttribute("num", MyType.CHAPTER_TEST_NUM);
			session.setAttribute("seq_num", 1);
			session.setAttribute("que_content", que_vo.getQue_content());
			session.setAttribute("que_type", que_vo.getQue_type());
			session.setAttribute("que_options", que_vo.getQue_options());
			session.setAttribute("que_url", que_vo.getQue_url());
			request.getRequestDispatcher("ChapterTesting.jsp").forward(request, response);
		}else {								
			//不在考试时间或考试有未完成的答题
			//更新session
			request.setAttribute("chapter_status", chapter_status);
			request.setAttribute("answer_status", answer_status);
			session.setAttribute("ans_id", ans_id_exist);
			request.getRequestDispatcher("ChapterIndex.jsp").forward(request, response);
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
