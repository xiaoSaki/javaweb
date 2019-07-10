package myInterceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyintercerptCheckLogin2 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj=session.getAttribute("user");
		System.out.println("检验是否登录成功："+obj);
		if(obj!=null){
			String value=invocation.invoke();
//			System.out.println(value);
			return value;
			
		}else{
			return "input";
		}
	}


}
