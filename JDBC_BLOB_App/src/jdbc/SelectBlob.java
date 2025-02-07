package jdbc;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import utilities.JDBCConnection;

public class SelectBlob {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Scanner sc = null;

		String selectQuery = " select * from userImage where uId = ?";

		int uId = 0;

		try {
			connection = JDBCConnection.getConnection();
			if (connection != null) {
				pStatement = connection.prepareStatement(selectQuery);
			}
			if (pStatement != null) {
				sc = new Scanner(System.in);
				System.out.print("Please Enter the Id : ");
				uId = sc.nextInt();

				pStatement.setInt(1, uId);

				resultSet = pStatement.executeQuery();
				if (resultSet != null) {
					if (resultSet.next()) {
						int userId = resultSet.getInt(1);
						String userName = resultSet.getString(2);
						
						//steps involved in getting the images
						// 1. we will get the input Stream and then we will create a file for storing the image
						// by using the fileOutputStream we will write the file and we will copy the binary stream into the newly create file
						InputStream is = resultSet.getBinaryStream(3);
						
						File file  = new File("newImage1.jpg");
						FileOutputStream fos = new FileOutputStream(file,true);
						int i = is.read();
						while(i != -1)
						{
							fos.write(i);
							i = is.read();
						}
						fos.close();
						
						
						
						
						
						
						System.out.println(userId + " \t" + userName + "\t" + file.getAbsolutePath());
					} else {
						System.out.println(" Record not available for the given id :: " + uId);
					}

				}

			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
