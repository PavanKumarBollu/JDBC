package com.pavan.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	private JdbcUtils() {
		// toPrevent the object Creation
	}

	static {
		try {
			String className = "com.mysql.cj.jdbc.Driver";
		 Class.forName(className);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		FileInputStream fis = new FileInputStream("src\\com\\pavan\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String uName = properties.getProperty("uName");
		String uPassword = properties.getProperty("uPassword");

		Connection connection = DriverManager.getConnection(url,uName,uPassword);
		return connection;
	}

	public static void CloseResources(Connection connection, Statement statement, ResultSet resultSet)
			throws SQLException {
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();

	}
}
