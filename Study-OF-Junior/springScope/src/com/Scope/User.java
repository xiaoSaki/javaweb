package com.Scope;

public class User {
	private String iname;
	@Override
	public String toString() {
		return "User [iname=" + iname + ", st=" + st + "]";
	}
	private String st;
	
	public User(String iname, String st) {
		super();
		this.iname = iname;
		this.st = st;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	
	
	
	public void print()
	{
		System.out.println("hello_world");
	}
	public void initMethod()
	{
		System.out.println("¿ªÊ¼");
	}
	public void destoryMethod()
	{
		System.out.println("½áÊø");
	}
	
			
}
