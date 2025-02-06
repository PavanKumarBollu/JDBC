package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UInputUpdateJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 2. Establish the connection with DB
		String url = "jdbc:mysql://localhost:3306/hms";
		String userName = "root";
		String password = "Pav@0211";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection Established SucussFully");
		
		//3. create a statement and execute Query
		
		Statement statement = connection.createStatement();
		
		//Taking the input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Role Id : Sample 143 : ");
		int rId= sc.nextInt();
		System.out.println("Enter the Role Description : ");
		String roleDesc = sc.next();
		
		
		
		//3.1 Update Query the Query
		
		String insertQuery1 = "INSERT INTO Role(`roleId`, `roleDesc`) values ("  + rId  + "," + "'" + roleDesc + "'" + ")" ;
		System.out.println(insertQuery1);
		int rowsEffected1 = statement.executeUpdate(insertQuery1);
		//2nd Way
		String insertQuery2 =String.format("INSERT INTO Role(`roleId`, `roleDesc`) values ('%d','%s')", rId+1, roleDesc) ;
		System.out.println(insertQuery2);
		int rowsEffected2 = statement.executeUpdate(insertQuery2);
		//3rd way
		int roleId = rId;
		String rDesc = "'" + roleDesc + "'";
		String insertQuery3 ="insert into Role(roleId, roleDesc) values(" + (roleId+2) +"," + rDesc +")";
		System.out.println(insertQuery3);
		int rowsEffected3 = statement.executeUpdate(insertQuery3);
		
		
		
		//checking the insertion
		System.out.println("Numbers of row Effected " + rowsEffected1);
		System.out.println("Numbers of row Effected " + rowsEffected2);
		System.out.println("Numbers of row Effected " + rowsEffected3);
		
		sc.close();
		statement.close();
		connection.close();
		

	}

}
