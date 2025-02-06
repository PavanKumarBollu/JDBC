import java.sql.*;
class TestApp 
{
	public static void main(String[] args) 
	{
		//Loading the Driver Class for making the Connection Between the JRE And MySql Environement
		// setting the classPath Variable in powershell--> $env:CLASSPATH = ";.;C:\Users\bpava\Downloads\mysql-connector-j-9.2.0.jar"
			
		//Creating the Connection Object to Store the Connection

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{	//1. Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded SuccussFully");
			
			// 2. establishing the connection
			String url = "jdbc:mysql://localhost:3306/hms";
			String userName = "root";
			String Password = "Pav@0211";

			connection =  DriverManager.getConnection(url, userName, Password);
			System.out.println("Connection Established Successfully...");
			System.out.println("Connection interface Implemented ClassName : " + connection.getClass().getName()); 

			//3. Creating  a Statement 
			String query = "Select EmployeeId, EmployeeNumber, EmailId, Password from Employee";

			statement = connection.createStatement();

			System.out.println("Statement interface Implemented ClassName : " + statement.getClass().getName()); 
			
			resultSet = statement.executeQuery(query);
			
			System.out.println("ResultSet interface Implemented ClassName : " + resultSet.getClass().getName()); 
			

			// 4. Processing the data
			System.out.println("");
			System.out.println("EmployeeId \tEmployeeNumber	\tEmailId \t\t\tPassword ");
			while(resultSet.next()){
				Integer eId			= resultSet.getInt(1);
				String eNumber		= resultSet.getString(2);
				String eEmail		= resultSet.getString(3);
				String ePassword	= resultSet.getString(4);

				System.out.println(eId + "\t\t" + eNumber + "\t\t\t" + eEmail + "\t"+ ePassword );
			}

		}catch (ClassNotFoundException ce){
			ce.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (connection != null)
				{
					connection.close();
					System.out.println("");
					System.out.println("Connection Closed");
					System.out.println("");
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("");
	}
}
