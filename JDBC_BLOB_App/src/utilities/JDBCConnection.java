package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnection {
	
	private JDBCConnection() {
		// private constructor is created to prevent the object creation
	}
	
	//variables for the user database credentials
	private static final String FILEPATH = "src/properties/application.properties";
	private static String url = null;
	private static String uName = null;
	private static String uPassword = null;
	
	// variables for the Creating Connection
	static private Connection connection = null;
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException
	{
		return establishConnection();
	}
	
	
	//method for doing the getting the credentials form the properties file
 	private static Boolean getCredentials () throws FileNotFoundException, IOException{
		FileInputStream fileIS = new FileInputStream(FILEPATH);
		Properties properties = new Properties();
		properties.load(fileIS);
		
		url = properties.getProperty("url");
		uName = properties.getProperty("uName");
		uPassword = properties.getProperty("uPassword");
		
		System.out.println(url + " " + uName + " " + uPassword);
		if(url != null && uName != null && uPassword != null)
			return true;
		else 
			return false;
		
	}
	
	private static Connection establishConnection() throws FileNotFoundException, IOException, SQLException
	{
		 
		if(getCredentials())
		{
			connection = DriverManager.getConnection(url, uName, uPassword);
		}
		if(connection != null)
			return connection;
		else 
			return null;
	}
	
	public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) throws SQLException
	{
		if(resultSet != null)
			resultSet.close();
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
	}
	
	
}
