package en.edu.lingnan.Filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		HttpSession session = req.getSession();
		String superuser = (String) session.getAttribute("supervalue");   //取出权限值
			if(superuser.equals("1"))  //管理员权限
			{
				arg2.doFilter(arg0,arg1);		
			}
		else{
			resp.sendRedirect(req.getContextPath()+"/authority.html");  //非管理员
		}
		}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
