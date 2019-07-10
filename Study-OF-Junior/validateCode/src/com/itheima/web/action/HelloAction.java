package com.itheima.web.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import cn.dsna.util.images.ValidateCode;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * Struts2的入门案例
 * @author zhy
 *
 */
public class HelloAction extends StrutsResultSupport{//锟斤拷锟斤拷锟斤拷

	/**
	 * 在动作类中的指定的动作方法
	 * 动作方法的书写要求：
	 * 		1、都是public的
	 * 		2、返回值必须是一个String
	 * 		3、必须没有参数
	 * @return
	 */
	private int height;
	private int width;
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	
	public String sayHello(){
		System.out.println("HelloAction的sayHello方法执行了");
		return "success";//与配置文件中result的name取值相对应
	}
    /*
     * (non-Javadoc)
     * @see org.apache.struts2.dispatcher.StrutsResultSupport#doExecute(java.lang.String, com.opensymphony.xwork2.ActionInvocation)
     * 重写doExecute的方法
     */
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		
		ValidateCode code= new ValidateCode(width,height,4,10);
		HttpServletResponse  Response  = ServletActionContext.getResponse();
		code.write(Response.getOutputStream());
	}
	
}
