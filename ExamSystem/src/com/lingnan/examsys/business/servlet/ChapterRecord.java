package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.domain.AnswerRecordPOJO;
import com.lingnan.examsys.business.domain.PageBean;
import com.lingnan.examsys.business.service.AnswerService;
import com.lingnan.examsys.business.service.AnswerServiceImpl;

/**
 * Servlet implementation class ChapterRecord
 */
@WebServlet(description = "学生端请求获取查看章节答题记录", urlPatterns = { "/students/record_chapter" })
public class ChapterRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterRecord() {
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
		
		AnswerService serv = AnswerServiceImpl.getInstance();
		
		PageBean<AnswerRecordPOJO> bean = serv.getChapterRecordByPageNo(user_id, pageNo, 10);
		
		request.setAttribute("chapter_record", bean);
		
		request.getRequestDispatcher("ChapterRecordIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
