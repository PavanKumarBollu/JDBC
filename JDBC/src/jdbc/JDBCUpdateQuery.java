package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
		
		
		String url = "jdbc:mysql:///hms";
		String uName = "root";
		String uPassword = "Pav@0211";
		
		Connection connection = DriverManager.getConnection(url, uName, uPassword);
		Statement statement = connection.createStatement();
		
		// updating the name of the Person 
		String updateQuery = "UPDATE Employee SET EmailId = '123@gmail.com' WHERE EmployeeId = 101";
		int result = statement.executeUpdate(updateQuery);
		
		System.out.println(result + " rows Effected");
	
		statement.close();
		connection.close();
		

	}

}
