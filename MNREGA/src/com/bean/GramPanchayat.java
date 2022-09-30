package com.bean;

public class GramPanchayat {

	private int gid;
	private String guserid;
	private String gpassword;
	private String glocation;
	public GramPanchayat() {
		
	}
	public GramPanchayat(int gid, String guserid, String gpassword, String glocation) {
		super();
		this.gid = gid;
		this.guserid = guserid;
		this.gpassword = gpassword;
		this.glocation = glocation;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGuserid() {
		return guserid;
	}
	public void setGuserid(String guserid) {
		this.guserid = guserid;
	}
	public String getGpassword() {
		return gpassword;
	}
	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}
	public String getGlocation() {
		return glocation;
	}
	public void setGlocation(String glocation) {
		this.glocation = glocation;
	}
	@Override
	public String toString() {
		return "GramPanchayat [gid=" + gid + ", guserid=" + guserid + ", gpassword=" + gpassword + ", glocation="
				+ glocation + "]";
	}
	
	
	
}
