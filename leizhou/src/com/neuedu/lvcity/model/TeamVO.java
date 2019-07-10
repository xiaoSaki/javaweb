package com.neuedu.lvcity.model;

public class TeamVO {
	private int teamid;
	private String content;
	
	
	public TeamVO() {
		super();
	}
	public TeamVO(int teamid, String content) {
		super();
		this.teamid = teamid;
		this.content = content;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
