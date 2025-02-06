package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertion {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
		
		
		String 	url 		= "jdbc:mysql:///hms";
		String 	uName 		= "root";
		String 	uPassword 	= "Pav@0211";
		Connection connection = DriverManager.getConnection(url, uName, uPassword);
		
		
		Statement statement = connection.createStatement();
		
		String inserQuery = "INSERT INTO Employee(EmployeeId, EmployeeNumber, EmailId, Password, CreatedBy, CreatedOn) VALUES\r\n"
				+ "(143, 'EMP143', 'pavan.kumar@gmail.com', 'Pav@0211', 1, '2025-02-5 08:02:00')";
		
		int result  = statement.executeUpdate(inserQuery );
		
		System.out.println(result + " rows effected");
		
	}
}
