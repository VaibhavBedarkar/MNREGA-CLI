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

public interface BDOdao {

	public String bdoLogin(String bdoId, String bdoPassword);
	
	public String createProject(String pname, String plocation, int prate);
	
	public List<Project> getAllProject() throws BDOException;
	
	public String registerGPM(GramPanchayat gramPanchayat) throws gpmException;

	public List<GramPanchayat> getAllGPM()throws PanchayatException;
	
	public String allocateEmployeeToProject (int eid, int pid, int wage)throws ProjectException,EmployeeException;
	
	public List<Employeedto> getEmployeeByProject(int eid,String ename,String pname, int wage) throws EmployeeException,ProjectException;
	
	


}
