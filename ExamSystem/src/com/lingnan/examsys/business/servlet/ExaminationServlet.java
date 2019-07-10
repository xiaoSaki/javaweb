package com.lingnan.examsys.business.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.service.ExaminationService;
import com.lingnan.examsys.business.service.ExaminationServiceImpl;


public class ExaminationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ExaminationServlet(){
		super();
	}

	protected void doGet(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException {
		doPost(req,resp);
	};

	protected void doPost(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException {
    HttpSession session = req.getSession();
    int exam_id = 0;
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
	ExaminationService examinationService = new ExaminationServiceImpl();	
	exam_id = examinationService.insertExam(user_id, exam_name, exam_begin, exam_end);
	session.setAttribute("exam_id", exam_id);
	resp.sendRedirect("que_exam.jsp");
};
}
