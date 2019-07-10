package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.service.Quetion_bankService;
import com.lingnan.examsys.business.service.Quetion_bankServiceImpl;

/**
 * Servlet implementation class ChapterInfo
 */
@WebServlet(description = "学生端获取章节测试信息，返回最大的章节数", urlPatterns = { "/students/chapter" })
public class ChapterInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Quetion_bankService serv = Quetion_bankServiceImpl.getInstance();
		
		int num = serv.getMaxChapterNum();
		
		request.setAttribute("max_chapter", num);
		
		request.getRequestDispatcher("ChapterIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
