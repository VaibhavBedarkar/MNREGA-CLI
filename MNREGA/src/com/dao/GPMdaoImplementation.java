package com.dao;

import java.util.List;

import com.bean.Employee;
import com.bean.GramPanchayat;
import com.exceptions.EmployeeException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;

public class GPMdaoImplementation implements GPMdao {

	@Override
	public GramPanchayat loginGPM(String guserid, String gpassword) throws gpmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createrEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getDetailsOfemployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmployeeToProject() throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDayandWageOfEmployee(int eid) throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		return 0;
	}

}
