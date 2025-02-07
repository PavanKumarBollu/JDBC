package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utilities.JDBCConnection;

public class JDBCInsert {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement =null;
		String insertQuery = "insert into Role (roleId,roleDesc) values(?,?)";
		Scanner sc = null;
		
		// variables for inserting the values into db
		int rId = 0;
		String rDesc = null;
		int rowsCount =0;
		
		try {
			connection = JDBCConnection.getConnection();
			if(connection != null)
				pStatement = connection.prepareStatement(insertQuery);
			if(pStatement != null)
			{
				sc = new Scanner(System.in);
				System.out.println("Enter Role id :: ");
				rId = sc.nextInt();
				System.out.println("Enter Role Desc :: " );
				rDesc = sc.next();
				
				pStatement.setInt(1, rId);
				pStatement.setString(2, rDesc);
				
				rowsCount = pStatement.executeUpdate();
				System.out.println(rowsCount + " Rows Are Affected");
				
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				sc.close();
				JDBCConnection.closeResources(connection, pStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
