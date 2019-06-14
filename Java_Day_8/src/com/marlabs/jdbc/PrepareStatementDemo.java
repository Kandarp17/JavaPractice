package com.marlabs.jdbc;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrepareStatementDemo {
	public static void main(String[] args) {
		Scanner sc= null;
		try {
			System.out.println("----------------------------");
			System.out.println("1) Display Department Employee Details Module");
			System.out.println("2) Register new employee");
			System.out.println("3) Register new employees");
			System.out.println("4) Register new employees using batch");
			System.out.println("----------------------------");
			sc=new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice= sc.nextInt();
			PreparedStatementExample preparedStatementExample= new PreparedStatementExample();
			switch(choice) {
			case 1:
				System.out.println("Enter Departement number: ");
				int departmentNumber= sc.nextInt();
				preparedStatementExample.getEmployeeDetails(departmentNumber);
				break;
			case 2:
				System.out.println("Enter Employee Number");
				int empNumber = sc.nextInt();
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Basic");
				double empBasic = sc.nextDouble();
				System.out.println("Enter Employee Dept Number");
				int empDeptNumber = sc.nextInt();
				boolean registrationFlag= preparedStatementExample.registerEmployee(empNumber, empName, empBasic, empDeptNumber);
				if(registrationFlag) {
					System.out.println("Registration Successfull");
				}
				break;
			case 3:
				preparedStatementExample.registerEmployee();
				break;
			case 4:
				preparedStatementExample.registerEmployeeBatch();
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
