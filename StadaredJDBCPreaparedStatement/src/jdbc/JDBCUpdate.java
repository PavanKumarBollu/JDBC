package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import utilities.JdbcUtils;

public class JDBCUpdate {

	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		String updateQueery = "Update Role set roleDesc = 'Updated by Java' where roleid = 1";
		int rowsEffected = 0;
		try{
			connection = JdbcUtils.getConnection();
			
			if(connection != null)
				statement = connection.createStatement();
			if(statement != null)
				 rowsEffected = statement.executeUpdate(updateQueery);
			System.out.println(rowsEffected + " : rows Are Affected");
			
		}catch(IOException ie){
			ie.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				JdbcUtils.closeResources(connection, statement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
