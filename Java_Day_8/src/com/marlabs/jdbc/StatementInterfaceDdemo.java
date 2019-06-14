package com.marlabs.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StatementInterfaceDdemo {
	public static void main(String[] args) {
		Scanner sc= null;
		try {
			System.out.println("----------------------------");
			System.out.println("1) Display Department Employee Details Module");
			System.out.println("2) Registered Employee Datials");
			System.out.println("3) DatabaseMetaData Interface Info");
			System.out.println("4) Register new employee");
			System.out.println("----------------------------");
			sc=new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice= sc.nextInt();
			StatementAPIExample statementAPIExample=new StatementAPIExample();
			switch(choice) {
			case 1:
				System.out.println("Enter Departement number: ");
				int departmentNumber= sc.nextInt();
				statementAPIExample.getEmployeeDeatils(departmentNumber);
				break;
			case 2:
				System.out.println("Enter Departement number: ");
				departmentNumber= sc.nextInt();
				statementAPIExample.getEmployeeDeatilsByRsmd(departmentNumber);
				break;
			case 3:
				statementAPIExample.getDatabaseMataDataInfo(); 
				break;
			case 4:
				System.out.println("Enter Employee Number");
				int empNumber = sc.nextInt();
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Basic");
				double empBasic = sc.nextDouble();
				System.out.println("Enter Employee Dept Number");
				int empDeptNumber = sc.nextInt();
				boolean registrationFlag= statementAPIExample.registerEmployee(empNumber, empName, empBasic, empDeptNumber);
				if(registrationFlag) {
					System.out.println("Registration Successfull");
				}
				break;
			case 5:
				 statementAPIExample.batchUpdatesExample();
				 break;
			default:
				System.out.println("Please Enter Correct Choice");
				break;
			}
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
}
