package jdbc;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import utilities.JDBCConnection;

public class insertDate {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		Scanner sc =null;
		
		String insertQuery ="insert into users(uName,uDOb) values(?,?)";
		String uName = null;
		String uDob = null;
		try
		{
			connection = JDBCConnection.getConnection();
			if(connection != null)
			{
				pStatement = connection.prepareStatement(insertQuery);
			}
			if(pStatement != null)
			{
				sc = new Scanner(System.in);
				System.out.print("Please Enter the Date in DD-MM-YYYY Format : ");
				uDob = sc.next();
				System.out.print("enter the name : ");
				uName = sc.next();
				
				String pattern = "dd-MM-yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				
				java.util.Date jDate = simpleDateFormat.parse(uDob);
				
				long time = jDate.getTime();
				
				java.sql.Date sDate = new java.sql.Date(time);
				
				pStatement.setString(1,uName);
				pStatement.setDate(2, sDate);
				
				int rowsCount = pStatement.executeUpdate();
				System.out.println(rowsCount + " Are Effected");
				
				pStatement.setString(1,uName);
				pStatement.setDate(2, sDate);
				
				int rowsCount1 = pStatement.executeUpdate();
				System.out.println(rowsCount1 + " Are Effected");
			}
			
			
		}catch(IOException | SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			sc.close();
			try {
				JDBCConnection.closeResources(connection, pStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
