package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.Noticetype;
import com.neuedu.lvcity.service.AdminService;
import com.neuedu.lvcity.service.ArticleService;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.NoticeService;
import com.neuedu.lvcity.service.NoticetypeService;
import com.neuedu.lvcity.service.impl.AdminServiceImpl;
import com.neuedu.lvcity.service.impl.ArticleServiceImpl;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;
import com.neuedu.lvcity.service.impl.NoticeServiceImpl;
import com.neuedu.lvcity.service.impl.NoticetypeServiceImpl;

/**
 * Servlet implementation class NoticeServlet
 */
//@WebServlet("/User/Notice")
public class NoticeServlet extends HttpServlet {

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防止取中文参数出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		 //显示左边所有动态分类
		if("show".equals(action)){
			doShow(request,response);
     	//显示对应分类下面的各种动态列表
		}else if("showList".equals(action)){
			doShowList(request,response);
			//查看某种动态的详细信息，包括发布人等
		}else if("watch".equals(action)){
			doWatch(request,response);
		}//模糊查询
		else if("search".equals(action)){
			doSearch(request,response);
		}
	}

	private void doShowList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
		
		// 获取动态service层实例
		NoticeService  noticeService =NoticeServiceImpl.getInstance();
		// 获取动态分类service层实例
		NoticetypeService  noticeTypeService =NoticetypeServiceImpl.getInstance();
		
		//获取从JSP页面传递过来的pageNow当前页参数
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		//获取从JSP页面传递过来的选择的当前动态分类
		int ntid = Integer.parseInt(request.getParameter("ntid"));

		int pageSize = 9;//一页9条数据
		int rowCount = noticeService.getCountByFtid(ntid);//该类型一共有几条数据
		//System.out.print("hahahh"+rowCount);
		if(rowCount == 0) {
			//设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		//System.out.println(rowCount);
		//System.out.println(zwjl);
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		//不足一页，默认显示第一页
		if(pageNow<1){
			pageNow=1;
		}
     //当前页超过最大页，设置当前页为最大页
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			//如果是第一页，从0开始
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("ntid",ntid);
		se.setAttribute("like","null");
		String noticetype = noticeTypeService.gettypebyid(ntid);//gettypebyid(ntid)getNoticeTypeById(ntid);
		se.setAttribute("noticetype",noticetype);
		
		List<Notice> noticelist = noticeService.noticeListByFtid(ntid, start);
		System.out.println(noticelist);
		se.setAttribute("noticelist",noticelist);
		
		 response.sendRedirect(request.getContextPath()
					+ "/User/noticelist.jsp");
	}

	private void doWatch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		  //获取session
        HttpSession se = request.getSession();
        
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int ntid = Integer.parseInt(request.getParameter("ntid"));
        int aid = Integer.parseInt(request.getParameter("aid"));
        
        //获取service
        ArticleService articleService = ArticleServiceImpl.getInstance();
        AdminService adminService = AdminServiceImpl.getInstance();
        
        Article articlevo = articleService.getArticleById(aid);
		Admin adminvo = adminService.getAdminById(articlevo.getPublisher());
		
		se.setAttribute("article",articlevo);
		se.setAttribute("admin",adminvo);
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("ntid",ntid);
		

		 response.sendRedirect(request.getContextPath()
					+ "/User/noticetext.jsp");
	}

	private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
		
		// 调用Service方法
		NoticetypeService  noticeTypeService =NoticetypeServiceImpl.getInstance();
		ContactService contactService = ContactServiceImpl.getInstance();
		
		List<Noticetype> noticetypelist = noticeTypeService.findNoticetype();
		se.setAttribute("noticetypelist",noticetypelist);
		
		int firstnoticetypeid = noticetypelist.get(1).getNtid();
		se.setAttribute("firstnoticetypeid",firstnoticetypeid);
		
		//联系方式处
		Contact contactvo = contactService.findContact();
		se.setAttribute("contact",contactvo);

		 response.sendRedirect(request.getContextPath()
					+ "/User/noticetype.jsp");
		
	}
	
	/**
	 * 模糊查询某分类下的公告
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	
	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String like = request.getParameter("like");
		
		int ntid =Integer.parseInt(request.getParameter("ntid"));
		int pageNow =Integer.parseInt( request.getParameter("pageNow"));
		
		if(like.trim().equals("null")) {
			doShowList(request, response);
		}else {
			cx(like, ntid, pageNow,request,response);
		}
		
	}
	/**
	 * 查询某分类下满足模糊查询的公告
	 * @param like
	 * @param ftid
	 * @param pageNow
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void cx(String like, int ntid, int pageNow,HttpServletRequest request, HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
        
		// 获取美食service层实例
        NoticeService  noticeService = NoticeServiceImpl.getInstance();
		// 获取美食分类service层实例
		NoticetypeService  noticetypeService = NoticetypeServiceImpl.getInstance();
		
		int pageSize = 9;//一页9条数据
		int rowCount = noticeService.getCountByLike("%"+like+"%", ntid);//该类型一共有几条数据
//		System.out.println("%"+like+"%");
//		System.out.println("数量"+rowCount);
		if(rowCount == 0) {
			se.setAttribute("zwjl", "1");
		}
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		if(pageNow<1){
			pageNow=1;
		}
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("ntid",ntid);
		se.setAttribute("like","null");
		String noticetype = noticetypeService.gettypebyid(ntid);
		se.setAttribute("noticetype",noticetype);
//		System.out.println("ttt"+like);
//		System.out.println("ff"+ntid);
//		System.out.println("g"+start);
		List<Notice> noticelist = noticeService.noticeListByLike("%"+like+"%", ntid, start);
		System.out.println(noticelist.size());	
		se.setAttribute("noticelist",noticelist);		
		 response.sendRedirect(request.getContextPath()
					+ "/User/noticelist.jsp");
		
	}
		
}

