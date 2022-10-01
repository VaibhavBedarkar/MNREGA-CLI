package com.dao;

import java.util.List;

import com.bean.Employeedto;
import com.bean.GramPanchayat;
import com.bean.Project;
import com.exceptions.BDOException;
import com.exceptions.EmployeeException;
import com.exceptions.PanchayatException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;

public class BDOdaoImplementation implements BDOdao{

	@Override
	public String bdoLogin(String bdoId, String bdoPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createProject(String pname, String plocation, int prate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProject() throws BDOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerGPM(GramPanchayat gramPanchayat) throws gpmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GramPanchayat> getAllGPM() throws PanchayatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allocateEmployeeToProject(int eid, int pid, int wage) throws ProjectException, EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employeedto> getEmployeeByProject(int eid, String ename, String pname, int wage)
			throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
