package com.marlabs.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CallableStatementDemo {
	public static void main(String[] args) {
		Scanner sc= null;
		try {
			System.out.println("----------------------------");
			System.out.println("1) Run Stored Procedure");
			System.out.println("2) Run SQL Fuunction");
			System.out.println("----------------------------");
			sc=new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice= sc.nextInt();
			CstExample cstExample=new CstExample();
			switch(choice) {
			case 1:
				cstExample.procedureExample();
				break;
			case 2:
				cstExample.functionExample();
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
