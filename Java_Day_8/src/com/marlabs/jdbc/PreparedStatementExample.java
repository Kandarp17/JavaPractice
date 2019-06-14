package com.marlabs.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PreparedStatementExample {
	public int registerEmployee() {
		String methodName = "registerEmployee()";
		System.out.println("Method Invoked:" + methodName);

		Connection connection = null;
		PreparedStatement pstStatement = null;
		int recordCount = 0;
		try {
			connection = DBUtil.getConnection();
			String insertQuery = "insert into emp2 values(?,?,?,?)";
			pstStatement = connection.prepareStatement(insertQuery); // Step -3
			// Step -4 Write And Execute SQL Query
			// insert into emp2 values(111,'AAA',9000.34,10);
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 10; i++) {
				System.out.println("Enter Employee Number");
				int empNumber = sc.nextInt();
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Basic");
				double empBasic = sc.nextDouble();
				System.out.println("Enter Employee Dept Number");
				int empDeptNumber = sc.nextInt();
				boolean result=registerEmployee(empNumber,empName,empBasic,empDeptNumber);
				if (result==true) {
					recordCount++;
				}
			}
			sc.close();
			connection.commit();
		} catch (SQLException e) {
			try {
				recordCount = 0;
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (InputMismatchException e) {
			try {
				recordCount = 0;
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		finally {
			try {
				// Step -5
				// Closing the Resources
				if(pstStatement!= null) {
					pstStatement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ recordCount);

		return recordCount;
	}
	
	public Boolean registerEmployee(int empNumber,String empName, double empBasic, int empDeptNumber) {
		String methodName = "registerEmployee(int empNumber,String empName, double empBasic, int empDeptNumber)";
		System.out.println("Method Invoked:" + methodName);

		Connection connection = null;
		PreparedStatement pstStatement = null;
		Boolean result=false;
		try {
			connection = DBUtil.getConnection();
			String insertQuery = "insert into emp2 values(?,?,?,?)";
			pstStatement = connection.prepareStatement(insertQuery); // Step -3
			// Step -4 Write And Execute SQL Query
			// insert into emp2 values(111,'AAA',9000.34,10);
			pstStatement.setInt(1, empNumber);
			pstStatement.setString(2, empName);
			pstStatement.setDouble(3, empBasic);
			pstStatement.setInt(4, empDeptNumber);
			int updateCount= pstStatement.executeUpdate();
			if(updateCount>0) {
				result=true;
			}
			connection.commit();
		}catch(SQLIntegrityConstraintViolationException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.err.println("EmployeeId Allready Exists in Table");
		}
		catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				// Step -5
				// Closing the Resources
				if(pstStatement!= null) {
					pstStatement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return result;
	}
	
	public void getEmployeeDetails(int empDeptNumber) {

		String methodName = "getEmployeeDetails()";
		System.out.println("Method Invoked:" + methodName);

		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String selectQuery = "select *from emp2 where empdeptno=?";
			pstStatement = connection.prepareStatement(selectQuery);
			pstStatement.setInt(1, empDeptNumber);
			resultSet = pstStatement.executeQuery();
			System.out.println("Emp Number" + "\t" + "Emp Name" + "\t"
					+ "Emp Sal" + "\t" + "Dept Number");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("empno") + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getDouble(3) + "\t");
				System.out.print(resultSet.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!= null) {
					resultSet.close();
				}	
				if(pstStatement!= null) {
					pstStatement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}
	public void registerEmployeeBatch() {
		String methodName = "registerEmployeeBatch()";
		System.out.println("Method Invoked:" + methodName);

		Connection connection = null;
		PreparedStatement pstStatement = null;
		try {
			connection = DBUtil.getConnection();
			String insertQuery = "insert into emp2 values(?,?,?,?)";
			pstStatement = connection.prepareStatement(insertQuery); // Step -3
			// Step -4 Write And Execute SQL Query
			// insert into emp2 values(111,'AAA',9000.34,10);
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 10; i++) {
				System.out.println("Enter Employee Number");
				int empNumber = sc.nextInt();
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Basic");
				double empBasic = sc.nextDouble();
				System.out.println("Enter Employee Dept Number");
				int empDeptNumber = sc.nextInt();
				pstStatement.setInt(1, empNumber);
				pstStatement.setString(2, empName);
				pstStatement.setDouble(3, empBasic);
				pstStatement.setInt(4, empDeptNumber);
				pstStatement.addBatch();
			}
			int[] result=pstStatement.executeBatch();
			for (int i = 0; i < result.length; i++) {
				System.out.println("Records Updated Count :" + "Query Number:"
						+ i + ":" + result[i]);
			}
			sc.close();
			connection.commit();
		}catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (InputMismatchException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		finally {
			try {
				// Step -5
				// Closing the Resources
				if(pstStatement!= null) {
					pstStatement.close();
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
