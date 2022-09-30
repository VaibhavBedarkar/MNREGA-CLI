package com.bean;

public class Employee {

	private int eid;
	private String pname;
	private String plocation;
	private int prate;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String pname, String plocation, int prate) {
		super();
		this.eid = eid;
		this.pname = pname;
		this.plocation = plocation;
		this.prate = prate;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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
		return "Employee [eid=" + eid + ", pname=" + pname + ", plocation=" + plocation + ", prate=" + prate + "]";
	}
	
	
	
	
}
