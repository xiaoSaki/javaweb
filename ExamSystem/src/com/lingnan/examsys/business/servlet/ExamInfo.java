package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.ExamInfoPOJO;
import com.lingnan.examsys.business.domain.PageBean;
import com.lingnan.examsys.business.service.ExaminationService;
import com.lingnan.examsys.business.service.ExaminationServiceImpl;

/**
 * Servlet implementation class ExamInfo
 */
@WebServlet(description = "学生获取考试信息以及其对考试的完成状态", urlPatterns = { "/students/exam" })
public class ExamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int user_id = (int) session.getAttribute("user_id");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		ExaminationService serv = ExaminationServiceImpl.getInstance();
		
		PageBean<ExamInfoPOJO> bean = serv.getExamInfo(user_id, pageNo, 10);
		
		request.setAttribute("exam_info", bean);
		
		request.getRequestDispatcher("ExamIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
