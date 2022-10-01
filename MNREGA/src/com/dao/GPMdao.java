package com.dao;

import java.util.List;

import com.bean.Employee;
import com.bean.GramPanchayat;
import com.exceptions.EmployeeException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;

public interface GPMdao {

	public GramPanchayat loginGPM(String guserid, String gpassword) throws gpmException; 
	
	public Employee createrEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getDetailsOfemployee()throws EmployeeException;
	
	public String assignEmployeeToProject() throws EmployeeException,ProjectException;
	
	public int getDayandWageOfEmployee(int eid) throws EmployeeException,ProjectException;
}
