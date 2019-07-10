package myInterceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Logininterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj=session.getAttribute("user");
		System.out.println("检验是否登录成功："+obj);
		if(obj!=null){
			String value=arg0.invoke();
//			System.out.println(value);
			return value;
			
		}else{
			return "input";
		}
	}

}
