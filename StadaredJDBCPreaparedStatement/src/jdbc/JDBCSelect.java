package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.JdbcUtils;



public class JDBCSelect {

	public static void main(String[] args){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner sc = null;
		
		String selectQuery = "select employeeId, employeeNumber, emailId, password from employee where employeeId = ?";
		
		try {
			connection = JdbcUtils.getConnection();
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if(preparedStatement != null)
			{
				sc= new Scanner(System.in);
				System.out.println("Enter the EmployeeId");
				int eId =sc.nextInt();
				
				preparedStatement.setInt(1, eId);
				
				resultSet = preparedStatement.executeQuery();
			}
			if(resultSet != null)
			{
				if(resultSet.next())
				{
					System.out.println( resultSet.getInt("EmployeeId") + "\t" + 
										resultSet.getString("employeeNumber") + "\t" + 
										resultSet.getString("emailid") + "\t"  +
										resultSet.getString("Password")
									);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				JdbcUtils.closeResources(connection, preparedStatement, resultSet);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
