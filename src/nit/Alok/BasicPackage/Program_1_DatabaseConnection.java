package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Program_1_DatabaseConnection {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "system";
	String dbPwd = "jaga";
	
	void connect() {
		try
		{
			IO.println("Loading Oracle Driver into JVM !!!");
			Class.forName(driver);
			IO.println("Driver is Loaded.");
			
			IO.println("Establishing Connection with Database !!!");
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("Connection is Established.");
			
			// Printing Connection object class Name--
			IO.println("Connection object class Name: " + conn);
			
			IO.println("Closing Connection !!!");
			conn.close();
			IO.println("Disconnected.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Program_1_DatabaseConnection obj = new Program_1_DatabaseConnection();
		obj.connect();
	}
}
