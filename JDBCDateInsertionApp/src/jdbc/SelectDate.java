package jdbc;


import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import utilities.JDBCConnection;

public class SelectDate {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet =null;
		Scanner sc =null;
		
		String selectQuery ="select * from users where uId = ?";
		
		int uId = 0;
		int userId =0;
		String userName = null;
		String userDob = null;
		try
		{
			connection = JDBCConnection.getConnection();
			if(connection != null)
			{
				pStatement = connection.prepareStatement(selectQuery);
			}
			if(pStatement != null)
			{
				sc = new Scanner(System.in);
				System.out.print("Please Enter the Id : ");
				uId = sc.nextInt();
				pStatement.setInt(1, uId);
				
				resultSet = pStatement.executeQuery();
				if(resultSet != null)
				{
					if(resultSet.next())
					{
						
						userId =resultSet.getInt(1);
						userName =resultSet.getString(2);
						java.util.Date date = resultSet.getDate(3);
						String formatedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
						System.out.println("Date Without Format :: " + date);
						System.out.println("Date With Format : " + formatedDate);
					}else {
						System.out.println("Record not available for the given id :: " + uId);
					}
					
				}
				
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
		}

	}

}
