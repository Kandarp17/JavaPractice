package com.marlabs.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CstExample {
	private Connection connection= null;
	private CallableStatement cstStatement= null;
	public void procedureExample() {
		//Stored Procedure Used in this example
				/*
				 create or replace procedure getSal(empno IN number,salary OUT number)
					as
					BEGIN
						select basic into salary from emp2 where eno=empno;
					END getSal;
				*/
		try {
			connection=DBUtil.getConnection();
			cstStatement=connection.prepareCall("{call getSal(?,?)}");
			cstStatement.setInt(1,501);
			cstStatement.registerOutParameter(2, Types.DOUBLE);
			cstStatement.execute();
			System.out.println("Salary for EMPID 501 = "+ cstStatement.getDouble(2));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cstStatement!=null) {
					cstStatement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void functionExample() {
		//SQL Function Used in this example
		/*
		 create or replace function getAvg(no1 number,no2 number)return number
			as
				sal1 number;
				sal2 number;
				BEGIN
					select basic into sal1 from emp2 where eno=no1;
					select basic into sal2 from emp2 where eno=no2;
					return (sal1+sal2)/2;
				END getAvg;
		 */
		try {
			connection=DBUtil.getConnection();
			cstStatement=connection.prepareCall("{?=call getAvg(?,?)}");
			cstStatement.registerOutParameter(1, Types.DOUBLE);
			cstStatement.setInt(2,501);
			cstStatement.setInt(3,115);
			cstStatement.execute();
			System.out.println("Average Salary = "+ cstStatement.getDouble(1));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cstStatement!=null) {
					cstStatement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
