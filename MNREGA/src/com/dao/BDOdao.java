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

	public String bdoLogin(String bdoId, String bdoPassword) throws BDOException;
	
	public String createProject(Project project)throws ProjectException;
	
	public List<Project> getAllProject() throws ProjectException;
	
	public String registerGPM(GramPanchayat gramPanchayat) throws gpmException;

	public List<GramPanchayat> getAllGPM()throws PanchayatException;
	
	public String allocateProjectToGPM(int gid, int pid) throws ProjectException, PanchayatException ;
	
	public List<Employeedto> getEmployeeByProject(int pid) throws EmployeeException,ProjectException;
	
	


}
