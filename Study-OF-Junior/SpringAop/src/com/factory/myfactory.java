package com.factory;

import com.service.UserService;
import com.serviceimpl.UserImpl;
import com.spect.MyAspect;

public class myfactory {
	//创建目标类
	final UserService userService = new UserImpl();
	final MyAspect myAspect = new MyAspect();
	UserService proxService = (UserService)Proxy.newProxyInstance(
			MyBeanFactory.class.getClassLoader(), 
			userService.getClass().getInterfaces(), 
			new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					
					//前执行
					myAspect.before();
					//执行目标类的方法
					Object obj = method.invoke(userService, args);
					//后执行
					myAspect.after();
					return obj;
				}
				}
			);
	return proxService;   
}

}
