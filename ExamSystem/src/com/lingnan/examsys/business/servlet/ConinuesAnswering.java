package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.domain.RecordVO;
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
 * Servlet implementation class ConinusAnswering
 */
@WebServlet(description = "学生意愿继续完成为完成的答题", urlPatterns = { "/students/continues_answering" })
public class ConinuesAnswering extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConinuesAnswering() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		AnswerService ans_serv = AnswerServiceImpl.getInstance();
		RecordService rec_serv = RecordServiceImpl.getInstance();
		Quetion_bankService que_serv = Quetion_bankServiceImpl.getInstance();
		ExaminationService exam_serv = ExaminationServiceImpl.getInstance();

		int user_id = (int) session.getAttribute("user_id");
		int ans_id = ans_serv.ifExistAnswering(user_id);
		AnswerVO ans_vo = ans_serv.getAnswerById(ans_id);
		RecordVO rec_vo = rec_serv.getLastQueidByExamidAndUserid(ans_vo.getExam_id(),ans_vo.getUser_id());
		Question_bankVO que_vo = que_serv.getQuetionById(rec_vo.getQue_id());
		ExaminationVO exam_vo = exam_serv.getExamByAnsid(ans_id);
	
		request.setAttribute("result", 0);
		session.setAttribute("ans_id", ans_id);
		session.setAttribute("ans_end",ans_vo.getAns_end());
		session.setAttribute("seq_num", rec_vo.getSeq_num());
		session.setAttribute("que_id", que_vo.getQue_id());
		session.setAttribute("que_type", que_vo.getQue_type());
		session.setAttribute("que_content", que_vo.getQue_content());
		session.setAttribute("que_options", que_vo.getQue_options());
		session.setAttribute("que_url", que_vo.getQue_url());
		
		//判断答题类型
		if(exam_vo.getUser_id() == 1) {
			session.setAttribute("num", MyType.CHAPTER_TEST_NUM);
			request.setAttribute("test_name", MyType.ChapterTestName(exam_vo.getChapter()));
			response.sendRedirect("ChapterTesting.jsp");
		}else {
			session.setAttribute("num",rec_serv.getNumOfAnswer(ans_id));
			request.setAttribute("test_name", exam_vo.getExam_name());
			response.sendRedirect("ExamTesting.jsp");
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
