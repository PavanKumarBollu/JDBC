class TestApp 
{
	public static void main(String[] args) 
	{
		//Loading the Driver Class for making the Connection Between the JRE And MySql Environement
		// setting the classPath Variable in powershell--> $env:CLASSPATH = ";.;C:\Users\bpava\Downloads\mysql-connector-j-9.2.0.jar"

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded SuccussFully");
		}
		catch (ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}

		System.out.println("");
	}
}
