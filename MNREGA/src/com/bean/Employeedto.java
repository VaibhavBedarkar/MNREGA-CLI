package com.bean;

public class Employeedto {

	private int eid;
	private String ename;
	private String pname;
	private int wage;
	
	public Employeedto() {
		super();
	}

	public Employeedto(int eid, String ename, String pname, int wage) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.pname = pname;
		this.wage = wage;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Employeedto [eid=" + eid + ", ename=" + ename + ", pname=" + pname + ", wage=" + wage + "]";
	}
	
	
	
}
