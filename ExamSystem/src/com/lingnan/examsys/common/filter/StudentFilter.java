package com.lingnan.examsys.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class StudentFilter
 */
@WebFilter(description = "学生端过滤器", urlPatterns = { "/students/*" })
public class StudentFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		//转换Servlet对象
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//获取登录用户的权限
		HttpSession se = req.getSession();
		int supervalue = 0;
		if(se.getAttribute("supervalue") != null && !se.getAttribute("supervalue").equals("")) {
			supervalue = (int) se.getAttribute("supervalue");
		}
//		String username = (String) se.getAttribute("username");
//		System.out.println("过滤器获得的用户名:"+username);
//		System.out.println("过滤器获得的权限值："+supervalue);
		
		//根据用户权限转跳
		if(supervalue == 1||supervalue == 3){
			chain.doFilter(req, resp);
		}else {
			se.setAttribute("supervalue", 0);
			resp.sendRedirect("/ExamSys/Login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
