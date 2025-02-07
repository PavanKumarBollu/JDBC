package utilities;
//import properties.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	
	private JdbcUtils()
	{
		// to prevent the Object Creation
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream("src/properties/application.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
				
		
		String url = properties.getProperty("url");
		String uName = properties.getProperty("uName");
		String uPassword = properties.getProperty("uPassword");
		
		Connection connection =  DriverManager.getConnection(url, uName, uPassword);
		return connection;
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
