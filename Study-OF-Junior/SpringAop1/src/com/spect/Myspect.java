package com.spect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//MethodInterceptor接口，是一种方法规范
public class Myspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("yu");
		Object obj = mi.proceed(); //手动放行
		System.out.println("tdt");
		return obj;
	}

}
