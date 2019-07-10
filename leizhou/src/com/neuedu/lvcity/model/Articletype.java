package com.neuedu.lvcity.model;

import java.io.Serializable;

public class Articletype implements Serializable{
	private int atid;
	private String atype;
	public Articletype() {
		super();
	}
	public Articletype(int atid, String atype) {
		super();
		this.atid = atid;
		this.atype = atype;
	}
	
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	
	

}
