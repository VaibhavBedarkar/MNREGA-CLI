package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.bean.GramPanchayat;
import com.exceptions.EmployeeException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;
import com.utility.DBUtility;

public class GPMdaoImplementation implements GPMdao {

	@Override
	public GramPanchayat loginGPM(String guserid, String gpassword) throws gpmException {
	
		GramPanchayat grampanchayat = null;
		
		
		try(Connection connection = DBUtility.establishConnection()){
			PreparedStatement ps = connection.prepareStatement("select * from gpm where guserid = ? AND gpassword = ?");
		
			ps.setString(1, guserid);
			ps.setString(2, gpassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int gid = rs.getInt("gid");
				String userid = rs.getString("guserid");
				String password = rs.getString("gpassword");
				String glocation = rs.getString("glocation");
				
				grampanchayat = new GramPanchayat(gid,userid,password,glocation);
					
			}else {
				throw new gpmException("Invalid Gram Panchayat Member");
			}
		
		
		
		
		}catch(SQLException e) {
			throw new gpmException(e.getMessage());
		}
		return grampanchayat;
	}

	@Override
	public String createrEmployee(Employee employee) throws EmployeeException {
		
		String message ="Registration failed..!";
		
		try(Connection connection = DBUtility.establishConnection()){
			PreparedStatement ps = connection.prepareStatement("insert into employee(ename,emobile,elocation) values(?,?,?)");
		
				ps.setString(1, employee.getEname());
				ps.setInt(2, employee.getEmobile());
				ps.setString(3, employee.getLocation());
		
				int res = ps.executeUpdate();
				
				if(res>0) message = "Employee Creation Successful";
		
		
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	
	}

	@Override
	public List<Employee> getDetailsOfemployee() throws EmployeeException {
		
		List<Employee> employee = new ArrayList<>();
		
		try(Connection connection = DBUtility.establishConnection()){
		
			PreparedStatement ps = connection.prepareStatement("select * from employee");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int emobile = rs.getInt("emobile");
				String elocation = rs.getString("elocation");
				
				Employee emp = new Employee(eid,ename,emobile,elocation);
				
				employee.add(emp);
					
			}		
		
		
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(employee.size()==0) throw new EmployeeException("No Employee found..");
		return employee;
	}

	@Override
	public String allocateEmployeeToProject(int eid, int pid, int wage) throws ProjectException, EmployeeException {
		
		String message ="Project Not Allocated to Employee..!";
		
		
		try(Connection conn= DBUtility.establishConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from employee where eid =?");
			
		 	
		 	ps.setInt(1, eid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from project where pid=?");
		 		
		 		ps2.setInt(1, pid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into emp_project values(?,?,?)");		 			
		 			
		 			ps3.setInt(1, eid);
		 			ps3.setInt(2, pid);
		 			ps3.setInt(3, wage);
		 			
		 			int res= ps3.executeUpdate();
		 			
		 			if(res > 0)
		 				message = "Employee Allocated to Project Sucessfully.. ";
		 			else
		 				throw new EmployeeException("Error Allocating Project");		 			
		 		}
		 		else
		 			throw new ProjectException("Invalid Project ID...");	 		
		 		
		 	}else
		 		throw new EmployeeException("Invalid Employee ID...");
		 	} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}	
		
		return message;
	}

	@Override
	public int getDayandWageOfEmployee(int eid, int pid) throws EmployeeException, ProjectException {
		
		int day = 0;
		
		try(Connection connection = DBUtility.establishConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select wage from emp_project where eid=? and pid=?");
			ps.setInt(1, eid);
			ps.setInt(2, pid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				day = rs.getInt("wage");
								
			}		
		
		
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(day==0) throw new EmployeeException("Employee didn't work on given project..");
		
		return day;
	}

}
