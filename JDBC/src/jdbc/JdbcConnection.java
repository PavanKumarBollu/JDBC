package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// from jdk 1.4 loading the driver is optional 
		/*
			//1. step one load the driver and inform the jvm that we are working with the jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Established SucussFully");
		*/
		
		
		// 2. Establish the connection with DB
		String url = "jdbc:mysql://localhost:3306/hms";
		String userName = "root";
		String password = "Pav@0211";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection Established SucussFully");
		
		//3. create a statement and execute Query
		
		Statement statement = connection.createStatement();
		
		//3.1 Executing the Query
		String selectQuery = "select EmployeeId, EmployeeNumber, EmailId, Password from Employee";
		
		//4. processing the result set
		ResultSet resultSet = statement.executeQuery(selectQuery );
		
		System.out.println("");
		System.out.println("EmployeeId \tEmployeeNumber	\tEmailId \t\t\tPassword ");
		
		while(resultSet.next())
		{
			Integer eId = resultSet.getInt("EmployeeId");
			String eNumber = resultSet.getString("EmployeeNumber");
			String eEmail = resultSet.getString("EmailId");
			String ePassword = resultSet.getString("Password");
			System.out.println(eId + "\t\t" + eNumber + "\t\t\t" + eEmail + "\t"+ ePassword );
			System.out.println("");
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		

	}

}
