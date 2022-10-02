package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.bean.Employeedto;
import com.bean.GramPanchayat;
import com.bean.Project;
import com.exceptions.BDOException;
import com.exceptions.EmployeeException;
import com.exceptions.PanchayatException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;
import com.utility.DBUtility;

public class BDOdaoImplementation implements BDOdao{

	@Override
	public String bdoLogin(String bdoId, String bdoPassword) throws BDOException {
		
		String message = "Login Failed..!";
		
		try(Connection connection = DBUtility.establishConnection()){
			PreparedStatement ps = connection.prepareStatement("select * from bdo where bdoid = ? AND bdopassword = ?");
		
			ps.setString(1, bdoId);
			ps.setString(2, bdoPassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString("bdoid");
				
					
			}else {
				throw new BDOException("Invalid BDO");
			}		
		
		}catch(SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String createProject(Project project)throws ProjectException {
		String message ="Project Creation failed..!";
		
		try(Connection connection = DBUtility.establishConnection()){
			PreparedStatement ps = connection.prepareStatement("insert into project(pname,plocation,prate) values(?,?,?)");
		
				ps.setString(1, project.getPname());				
				ps.setString(2, project.getPlocation());
				ps.setInt(3,project.getPrate());
		
				int res = ps.executeUpdate();
				
				if(res>0) message = "Project Creation Successful";
		
		
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public List<Project> getAllProject() throws ProjectException {
		
		List<Project> project = new ArrayList<>();
		
		try(Connection connection = DBUtility.establishConnection()){
		
			PreparedStatement ps = connection.prepareStatement("select * from project");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");				
				String plocation = rs.getString("plocation");
				int prate = rs.getInt("prate");
				
				Project proj = new Project(pid,pname,plocation,prate);
				
				project.add(proj);
					
			}		
		
		
		}catch(SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(project.size()==0) throw new ProjectException("No Project found..");
		return project;
		
	}

	@Override
	public String registerGPM(GramPanchayat gramPanchayat) throws gpmException {
		String message ="Gram-Panchayat Registration failed..!";
		
		try(Connection connection = DBUtility.establishConnection()){
			PreparedStatement ps = connection.prepareStatement("insert into gpm(guserid,gpassword,glocation) values(?,?,?)");
		
				ps.setString(1, gramPanchayat.getGuserid());				
				ps.setString(2,gramPanchayat.getGpassword());
				ps.setString(3,gramPanchayat.getGlocation());
		
				int res = ps.executeUpdate();
				
				if(res>0) message = "Gram-Panchayat Created Successful";
		
		
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public List<GramPanchayat> getAllGPM() throws PanchayatException {
		List<GramPanchayat> gp = new ArrayList<>();
		
		try(Connection connection = DBUtility.establishConnection()){
		
			PreparedStatement ps = connection.prepareStatement("select * from gpm");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int gid = rs.getInt("gid");
				String guserid = rs.getString("guserid");				
				String gpassword = rs.getString("gpassword");
				String glocation = rs.getString("glocation");
				
				GramPanchayat gpp = new GramPanchayat(gid,guserid,gpassword,glocation);
				
				gp.add(gpp);
					
			}		
		
		
		}catch(SQLException e) {
			throw new PanchayatException(e.getMessage());
		}
		
		if(gp.size()==0) throw new PanchayatException("GramPanchayat not found..");
		return gp;
	}

	@Override
	public String allocateProjectToGPM(int gid, int pid) throws ProjectException, PanchayatException {
		
		String message ="Project Not Allocated to GPM..!";
		
		
		try(Connection conn= DBUtility.establishConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from gpm where gid =?");
			
		 	
		 	ps.setInt(1, gid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from project where pid=?");
		 		
		 		ps2.setInt(1, pid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into gpm_project values(?,?)");		 			
		 			
		 			ps3.setInt(1, gid);
		 			ps3.setInt(2, pid);
		 			 			
		 			int res= ps3.executeUpdate();
		 			
		 			if(res > 0)
		 				message = "Project Allocated to GPM Sucessfully.. ";
		 			else
		 				throw new PanchayatException("Error Allocating Project");		 			
		 		}
		 		else
		 			throw new ProjectException("Invalid Project ID...");	 		
		 		
		 	}else
		 		throw new PanchayatException("Invalid Employee ID...");
		 	} catch (SQLException e) {
			throw new PanchayatException(e.getMessage());
		}	
		
		return message;
	}

	@Override
	public List<Employeedto> getEmployeeByProject(int pid)
			throws EmployeeException, ProjectException {		
		
		ArrayList<Employeedto> etos = new ArrayList<>();		
		
		try (Connection connection = DBUtility.establishConnection()){
			
			PreparedStatement ps= connection.prepareStatement("select e.eid, e.ename, p.pname, ep.wage "
														+ "from employee e INNER JOIN project p INNER JOIN emp_project ep "
														+ "ON e.eid = ep.eid AND p.pid = ep.pid AND p.pid= ?");
			
			ps.setInt(1, pid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int eid= rs.getInt("eid");
				String ename= rs.getString("ename");
				String pname= rs.getString("pname");
				int wage= rs.getInt("wage");
				
				Employeedto eto = new Employeedto(eid,ename,pname,wage);
				
				etos.add(eto);			
				
			}		
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}		
		
		if(etos.isEmpty())throw new ProjectException("No Employee found in the Project");	
		
		return etos;
	}

}
