package jdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import utilities.JDBCConnection;

public class InsertBlobApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		
		//String insertQuery ="insert into userImage(uId,uName,uImage) values(?,?,?)";
		String insertQuery ="insert into userImage(uName,uImage) values(?,?)";
		
		//int uId = 101;
		String uName = null;
		String uImageLocation = null;
		try
		{
			connection = JDBCConnection.getConnection();
			if(connection != null)
			{
				pStatement = connection.prepareStatement(insertQuery);
			}
			if(pStatement != null)
			{
				uName ="Pavan";
				uImageLocation = "D:\\Pavan/photo6.jpg";
				
				// 1 way
//				File file = new File(uImageLocation);
//				FileInputStream fis = new FileInputStream(file);
				// 2 way
//				FileInputStream fis = new FileInputStream(new File(uImageLocation));
			
				//pStatement.setInt(1, uId);
				pStatement.setString(1, uName);
				pStatement.setBinaryStream(2, new FileInputStream(new File(uImageLocation)));// 3 way
				
				int rowsCount = pStatement.executeUpdate();
				System.out.println(rowsCount + "Rows Are Effected");
							
				
			}
			
			
		}catch(IOException | SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			
			try {
				JDBCConnection.closeResources(connection, pStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
