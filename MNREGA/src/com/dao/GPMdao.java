package com.dao;

import java.util.List;

import com.bean.Employee;
import com.bean.GramPanchayat;
import com.exceptions.EmployeeException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;

public interface GPMdao {

	public GramPanchayat loginGPM(String guserid, String gpassword) throws gpmException; 
	
	public String createrEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getDetailsOfemployee()throws EmployeeException;
	
	public String allocateEmployeeToProject (int eid, int pid, int wage)throws ProjectException,EmployeeException;
	
	public int getDayandWageOfEmployee(int eid, int pid) throws EmployeeException,ProjectException;
}
