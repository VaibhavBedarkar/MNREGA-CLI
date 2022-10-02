package com.bean;

public class Employee {
	private int eid;
	private String ename;
	private int emobile;
	private String location;
	public Employee() {
		super();
	}
	public Employee(int eid, String ename, int emobile, String location) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.emobile = emobile;
		this.location = location;
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
	public int getEmobile() {
		return emobile;
	}
	public void setEmobile(int emobile) {
		this.emobile = emobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", emobile=" + emobile + ", location=" + location + "]";
	}
	
	
	
	
}
