package com.bean;

public class GPMdto {

	private int gid;
	private int pid;
	private String guserid;
	private String pname;
	public GPMdto() {
		super();
	}
	public GPMdto(int gid, int pid, String guserid, String pname) {
		super();
		this.gid = gid;
		this.pid = pid;
		this.guserid = guserid;
		this.pname = pname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getGuserid() {
		return guserid;
	}
	public void setGuserid(String guserid) {
		this.guserid = guserid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "GPMdto [gid=" + gid + ", pid=" + pid + ", guserid=" + guserid + ", pname=" + pname + "]";
	}
	
	
	
	
}
