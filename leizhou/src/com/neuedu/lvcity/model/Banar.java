package com.neuedu.lvcity.model;

public class Banar {
	private int banarid;
	private String image;
	private int state;
	public Banar() {
		super();
	}
	public Banar(int bannarid, String image, int state) {
		super();
		this.banarid = bannarid;
		this.image = image;
		this.state = state;
	}
	public int getBanarid() {
		return banarid;
	}
	public void setBanarid(int banarid) {
		this.banarid = banarid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
