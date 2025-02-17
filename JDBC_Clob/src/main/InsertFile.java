package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pavan.utils.JdbcUtils;

public class InsertFile {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JdbcUtils.getJdbcConnection();
			
			String insertQuery = "insert into clob(fileName, fileData) values (?,?)";
			
		 preparedStatement	= connection.prepareStatement(insertQuery);
		 
		 int rowsEffected = preparedStatement.executeUpdate();	
		 
		 System.out.println(rowsEffected + "Rows Are Effected");
			
		} catch (SQLException | IOException e) {
		
			e.printStackTrace();
		}
	}
}
