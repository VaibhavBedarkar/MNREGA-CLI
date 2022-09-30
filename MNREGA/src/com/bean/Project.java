package com.bean;

public class Project {

	private int pid;
	private String pname;
	private String plocation;
	private int prate;
	
	public Project() {
		
	}
	
	public Project(int pid, String pname, String plocation, int prate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.plocation = plocation;
		this.prate = prate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public int getPrate() {
		return prate;
	}

	public void setPrate(int prate) {
		this.prate = prate;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", plocation=" + plocation + ", prate=" + prate + "]";
	}
	
	
	
}
