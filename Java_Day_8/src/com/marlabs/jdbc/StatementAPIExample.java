package com.marlabs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


public class StatementAPIExample {
	public void getEmployeeDeatils(int departmentNumber) {
		Connection con=null;
		Statement st=null;
		ResultSet resultSet=null;
				
		try {
			con=DBUtil.getConnection();
			st=con.createStatement();
			final String SELECT_QUERY= "SELECT * from emp WHERE dno="
					+ departmentNumber;
			resultSet= st.executeQuery(SELECT_QUERY);
			while( resultSet.next()) {
				System.out.print(resultSet.getInt(1)+"\t");
				System.out.print(resultSet.getString(2)+"\t");
				System.out.print(resultSet.getString(3)+"\t");
				System.out.print(resultSet.getInt(4)+"\t");
				System.out.print(resultSet.getDate(5)+"\t");
				System.out.print(resultSet.getDouble(6)+"\t");
				System.out.print(resultSet.getDouble(7)+"\t");
				System.out.print(resultSet.getInt("DNO")+"\t");
				System.out.println();
			}
			
		}catch( SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!= null) {
					resultSet.close();
				}	
				if(st!= null) {
					st.close();
				}
				if(con!= null) {
					con.close();
				}
				
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void getEmployeeDeatilsByRsmd(int departmentNumber) {
		Connection con=null;
		Statement st=null;
		ResultSet resultSet=null;
				
		try {
			con=DBUtil.getConnection();
			st=con.createStatement();
			final String SELECT_QUERY= "SELECT * from emp WHERE dno="
					+ departmentNumber;
			resultSet= st.executeQuery(SELECT_QUERY);
			java.sql.ResultSetMetaData rsmd= resultSet.getMetaData(); 
			int columnCount= rsmd.getColumnCount();
			System.out.println("Number of Columns: "+ columnCount);
			System.out.println("-----------------------------------");
			// in resultset column count starts with 1
			for( int i=1; i<=columnCount;i++) {
				System.out.print(rsmd.getColumnName(i)+ "\t");
			}
			System.out.println("-----------------------------------");
			while( resultSet.next()) {
				for( int i=1; i<=columnCount;i++) {
					System.out.print(resultSet.getString(i)+ "\t");
				}
			}
			
		}catch( SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!= null) {
					resultSet.close();
				}	
				if(st!= null) {
					st.close();
				}
				if(con!= null) {
					con.close();
				}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void getDatabaseMataDataInfo() {
		Connection conn= null;
		try {
			conn=DBUtil.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverMinorVersion());
			System.out.println(dbmd.getDriverMajorVersion());
			System.out.println(dbmd.getSQLKeywords());
			System.out.println(dbmd.getStringFunctions());
			System.out.println(dbmd.getNumericFunctions());
			System.out.println(dbmd.getSystemFunctions());
			System.out.println(dbmd.supportsBatchUpdates());
			System.out.println(dbmd.supportsStoredProcedures());

			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			try {
				if(conn!= null) {
					conn.close();
				}
				
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public boolean registerEmployee(int empNumber,String empName, double empBasic, int empDeptNumber) {
		String methodName = "registerEmployee()";
		System.out.println("Method Invoked:" + methodName);
		boolean successFlag = false;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement(); // Step -3
			// Step -4 Write And Execute SQL Query
			// insert into emp2 values(111,'AAA',9000.34,10);
			String insertQuery = "insert into emp2 values(" + empNumber + ",'"
					+ empName + "'," + empBasic + "," + empDeptNumber + ")";
			int updateCount = statement.executeUpdate(insertQuery);
			if (updateCount > 0) {
				successFlag = true;
			}

		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			System.err.println("Employee ID Already Exists");
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement!= null) {
					statement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return successFlag;
	}
	
	public void batchUpdatesExample() {
		System.out.println("From Batch Updates Example Method");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBUtil. getConnection();
			statement = connection.createStatement();
			//By default auto commit is free in jdbc   
			connection.setAutoCommit(false);
			String insertQuery = "insert into emp2 values(118,'DFGH',7890.45,20)";
			String updateQuery = "update emp2 set empBasic=empBasic+1000 where empdeptno=10";
			String deleteQuery = "delete from emp2 where empdeptno=30;";
			statement.addBatch(insertQuery);
			statement.addBatch(updateQuery);
			statement.addBatch(deleteQuery);
			int updateCount[] = statement.executeBatch();
			for (int i = 0; i < updateCount.length; i++) {
				System.out.println("Records Updated Count :" + "Query Number:"
						+ i + ":" + updateCount[i]);
			}
			connection.commit();
		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(statement!= null) {
					statement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
