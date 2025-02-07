package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilities.JdbcUtils;



public class JDBCSelect {

	public static void main(String[] args){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String selectQuery = "select employeeId, employeeNumber, emailId, password from employee";
		
		try {
			connection = JdbcUtils.getConnection();
			if(connection != null)
			{
				statement = connection.createStatement();
			}
			if(statement != null)
			{
				resultSet = statement.executeQuery(selectQuery);
			}
			if(resultSet != null)
			{
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + 
							resultSet.getString(3)+ "\t" + resultSet.getString(4));
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
				JdbcUtils.closeResources(connection, statement, resultSet);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
