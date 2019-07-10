package com.lingnan.examsys.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * POJO对象，返回数据信息给浏览器的容器
 * @author Administrator
 *
 */
public class Msg {
	//存有信息涵义的特殊编码
	private int code;
	//返回提示信息
	private String msg;
	//协带返回给浏览器的数据
	private Map<String,Object> extend = new HashMap<String,Object>();
	
	public static Msg success() {
		Msg result = new Msg();
	    result.setCode(100);
	    result.setMsg("登录成功");
	    return result;
	}
	
	public static Msg fail() {
		Msg result = new Msg();
	    result.setCode(201);
	    result.setMsg("登录失败，账户或密码不正确！");
	    return result;
	}
	
	/**
	 * 让Msg对象协带需要发送的数据
	 * @param key 关键字
	 * @param value 数据
	 * @return Msg对象
	 */
	public Msg add(String key,Object value) {
	    this.getExtend().put(key, value);
	    return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
}
