package com.use;

import java.util.List;
import java.util.Scanner;

import com.bean.Employee;
import com.bean.Employeedto;
import com.bean.GramPanchayat;
import com.bean.Project;
import com.dao.BDOdao;
import com.dao.BDOdaoImplementation;
import com.dao.GPMdao;
import com.dao.GPMdaoImplementation;
import com.exceptions.BDOException;
import com.exceptions.EmployeeException;
import com.exceptions.PanchayatException;
import com.exceptions.ProjectException;
import com.exceptions.gpmException;

public class MnregaApplication{
	
	public static void GPMFunctions () {
		Scanner scanner  = new Scanner(System.in);
		
		
		System.out.println("Welcome to GPM Module");
		System.out.println("----------------------");
		
		System.out.print("Enter GPMUser Id: ");
		String gpmUserID = scanner.next();
		

		System.out.print("Enter GPMUser Password: ");
		String gpmUserpassword = scanner.next();
		
		System.out.println("----------------------");
		
		GPMdao gpmdao = new GPMdaoImplementation();
		
		try {
			gpmdao.loginGPM(gpmUserID, gpmUserpassword);
			
			System.out.println("Welcome GPM : "+gpmUserID);
			
			char cont;
			do {
				System.out.println("-----------------------------");
				System.out.println("1. Create Employee");
				System.out.println("2. View Employee Details");
				System.out.println("3. Allocate Employee to Projects");
				System.out.println("4. View days Employeee worked on Project and wage");
				System.out.println("-----------------------------");
				System.out.println("Enter CHOICE:");
				System.out.println("-----------------------------");
				
				int choice = scanner.nextInt();
				switch(choice) {
				
				
				case 1:{
					
					System.out.println("Enter Employee Name:");
					String ename= scanner.next();			
					
					
					System.out.println("Enter Employee Mobile no:");
					int emobile= scanner.nextInt();
					
					System.out.println("Enter Employee Location:");
					String elocation= scanner.next();				
					
									
					Employee employee = new Employee();
					employee.setEname(ename);
					employee.setEmobile(emobile);
					employee.setLocation(elocation);					
					
					String result;
					try {
						result = gpmdao.createrEmployee(employee);
						System.out.println(result);
						
					} catch (EmployeeException e) {
						System.out.println(e.getMessage());
					}				
					break;
				}
				case 2:{
					try {
						List<Employee> employee= gpmdao.getDetailsOfemployee();
						employee.forEach(e ->{
							System.out.println("=======================");
							System.out.println("Employee ID :"+e.getEid());
							System.out.println("Employee Name: "+e.getEname());
							System.out.println("Employee Location: "+e.getLocation());
							System.out.println("Employee Mobile: "+e.getEmobile());
							System.out.println("=======================");
							
						});					
					
					} catch (EmployeeException e) {
				
						System.out.println(e.getMessage());
					}
					break;
				}
				case 3:{
					
					System.out.println("Enter the eid of Employee");
					int eid= scanner.nextInt();

					System.out.println("Enter the pid of Project");
					int pid= scanner.nextInt();
					
					System.out.println("Enter the days Employee will work for");
					int days= scanner.nextInt();					
					
					
					try {
					String result = gpmdao.allocateEmployeeToProject(eid, pid, days);
					
					System.out.println(result);
					
					}catch(Exception e) {
						
						System.out.println(e.getMessage());
						
					}			
					
					break;
				}
				case 4:{
					System.out.println("Enter the eid of Employee");
					int eid= scanner.nextInt();

					System.out.println("Enter the pid of Project");
					int pid= scanner.nextInt();
					
					try {
						int result = gpmdao.getDayandWageOfEmployee(eid, pid);
						int wage = result*120; 
						System.out.println("Employee no: "+eid+" worked on Project no: "+pid+ " For "+result+" Days and wage is ₹ "+wage);
						
						}catch(Exception e) {
							
							System.out.println(e.getMessage());
							
						}	
					
					break;
				}				
				}
				System.out.println("Do you want to continue?(y/n)");
				cont=scanner.next().charAt(0);
				
			}while(cont=='Y' ||cont=='y');
		} catch (gpmException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	public static void BDOFunctions() {
		Scanner scanner  = new Scanner(System.in);
		
		
		System.out.println("Welcome to BDO Module");
		System.out.println("----------------------");
		
		System.out.print("Enter BDOUser Id: ");
		String bdoUserID = scanner.next();
		

		System.out.print("Enter BDOUser Password: ");
		String bdopassword = scanner.next();
		
		System.out.println("----------------------");
		
		BDOdao bdodao = new BDOdaoImplementation();
		
		try {
			bdodao.bdoLogin(bdoUserID, bdopassword);
			
			System.out.println("Welcome BDO : "+bdoUserID);
			
			char cont;
			do {
				System.out.println("-----------------------------");
				System.out.println("1. Create Project");
				System.out.println("2. View Projects");
				System.out.println("3. Create Gram Panchayat Member");
				System.out.println("4. View All Gram Panchayat Member");
				System.out.println("5. Allocate Projects to Gram Panchayat Member");
				System.out.println("6. List of Employeee working on Project ID");
				System.out.println("-----------------------------");
				System.out.println("Enter CHOICE:");
				System.out.println("-----------------------------");
				
				int choice = scanner.nextInt();
				switch(choice) {
				
				
				case 1:{
					
					System.out.println("Enter Project Name:");
					String pname= scanner.next();			
					
					
					System.out.println("Enter Project location:");
					String plocation= scanner.next();
					
					System.out.println("Enter Project rate:");
					int prate= scanner.nextInt();				
					
					BDOdao dao = new BDOdaoImplementation();					
					
					
					Project project= new Project();
					project.setPname(pname);
					project.setPlocation(plocation);
					project.setPrate(prate);
					
					
					
					
					String result;
					try {
						result = dao.createProject(project);
						System.out.println(result);
						
					} catch (ProjectException e) {
						
						System.out.println(e.getMessage());
					}
							
					break;
				}
				case 2:{
					try {
						List<Project> project= bdodao.getAllProject();
						project.forEach(p ->{
							System.out.println("=======================");
							System.out.println("Project ID :"+p.getPid());
							System.out.println("Project Name: "+p.getPname());
							System.out.println("Project Location: "+p.getPlocation());
							System.out.println("Project Rate: "+p.getPrate());
							System.out.println("=======================");
							
						});					
					
					} catch (ProjectException e) {
				
						System.out.println(e.getMessage());
					}
					break;
				}
				case 3:{
					
					System.out.println("Enter GramPanchayat UserID:");
					String guserid= scanner.next();			
					
					
					System.out.println("Enter GramPanchayat Password:");
					String gpassword= scanner.next();
					
					System.out.println("Enter GramPanchayat Location:");
					String glocation= scanner.next();				
					
									
					GramPanchayat grampanchayat= new GramPanchayat();
					grampanchayat.setGuserid(guserid);	
					grampanchayat.setGpassword(gpassword);
					grampanchayat.setGlocation(glocation);				
					
					String result;
					
						try {
							result = bdodao.registerGPM(grampanchayat);
							System.out.println(result);
						} catch (gpmException e) {
							System.out.println(e.getMessage());
						}			
					
					break;
				}
				case 4:{
					
					try {
						
						List<GramPanchayat> grampanchayat= bdodao.getAllGPM();
						grampanchayat.forEach(g ->{
							System.out.println("=======================");
							System.out.println("GramPanchayat No:"+g.getGid());
							System.out.println("GramPanchayat ID :"+g.getGuserid());
							System.out.println("GramPanchayat Password: "+g.getGpassword());
							System.out.println("GramPanchayat Location: "+g.getGlocation());
							System.out.println("=======================");
							
						});					
					
					} catch (PanchayatException e) {
				
						System.out.println(e.getMessage());
					}
					
					
					
					break;
				}
				case 5:{
					System.out.println("Enter the Pid of Project");
					int pid= scanner.nextInt();

					System.out.println("Enter the gid of Panchyat");
					int gid= scanner.nextInt();
										
					
					try {
					String result = bdodao.allocateProjectToGPM(gid, pid);
					
					System.out.println(result);
					
					}catch(Exception e) {
						
						System.out.println(e.getMessage());
						
					}
					break;
				}
				case 6:{
					
					try {
						
						System.out.println("Enter Project No. to fetch employee assigned to it");
						int eid = scanner.nextInt();
						
						List<Employeedto> employeeDTO= bdodao.getEmployeeByProject(eid);
						
						employeeDTO.forEach(e ->{
							System.out.println("=======================");
							System.out.println("Employee No:"+e.getEid());
							System.out.println("Employee Name :"+e.getEname());
							System.out.println("Project Name: "+e.getPname());
							System.out.println("Total Days Employee worked for : "+e.getWage());
							System.out.println("Total Wage: "+(e.getWage()*120));
							System.out.println("=======================");
							
						});					
					
					} catch (ProjectException | EmployeeException e) {				
						System.out.println(e.getMessage());
					}
					break;
				}
			
				}
				System.out.println("Do you want to continue?(y/n)");
				cont=scanner.next().charAt(0);
				
			}while(cont=='Y' ||cont=='y');
		} catch (BDOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	

	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(""
				+ "                                                                                         \r\n"
				+ "88b           d88  888b      88  88888888ba   88888888888  ,ad8888ba,         db         \r\n"
				+ "888b         d888  8888b     88  88      \"8b  88          d8\"'    `\"8b       d88b        \r\n"
				+ "88`8b       d8'88  88 `8b    88  88      ,8P  88         d8'                d8'`8b       \r\n"
				+ "88 `8b     d8' 88  88  `8b   88  88aaaaaa8P'  88aaaaa    88                d8'  `8b      \r\n"
				+ "88  `8b   d8'  88  88   `8b  88  88\"\"\"\"88'    88\"\"\"\"\"    88      88888    d8YaaaaY8b     \r\n"
				+ "88   `8b d8'   88  88    `8b 88  88    `8b    88         Y8,        88   d8\"\"\"\"\"\"\"\"8b    \r\n"
				+ "88    `888'    88  88     `8888  88     `8b   88          Y8a.    .a88  d8'        `8b   \r\n"
				+ "88     `8'     88  88      `888  88      `8b  88888888888  `\"Y88888P\"  d8'          `8b");
		
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
		char cont;
		do {
			System.out.println("1. BDO Login");
			System.out.println("2. GPM Login");
			System.out.println("-----------------------------");
			System.out.println("Enter User type:");
			System.out.println("-----------------------------");
			
			int choice = scanner.nextInt();
			switch(choice) {
			
			
			case 1:{
				BDOFunctions();
				break;
			}
			case 2:{
				GPMFunctions();
				break;
			}
		
			}
			System.out.println("Exit (y/n)");
			cont=scanner.next().charAt(0);
			
		}while(cont=='Y' ||cont=='y');
		

	}

}
