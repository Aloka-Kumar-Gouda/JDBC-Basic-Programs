package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program_2_SchemaCreation {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "system";
	String dbPwd = "jaga";
	
	void createSchema() {
		try
		{
			IO.println("Loading Oracle Driver into JVM !!!");
			Class.forName(driver);
			IO.println("Driver is Loaded.");
			
			IO.println("Establishing Connection with Database !!!");
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("Connection is Established.");
			IO.println("\n");
			
			IO.println("Creating Statement Object---");
			Statement stmt = conn.createStatement();
			IO.println("Statement is Created.");
			
			IO.println("Executing Queries for Creating Schema on Database---");
			stmt.execute("alter session set\"_oracle_script\" = true");
			stmt.execute("create user alokjdbc identified by akj");
			stmt.execute("grant connect, resource, unlimited tablespace to alokjdbc");
			IO.println("Schema/User is Created and DBA Permissions are Granted.");
			
			IO.println("Closing Connection !!!");
			stmt.close();
			conn.close();
			IO.println("Disconnected.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Program_2_SchemaCreation obj = new Program_2_SchemaCreation();
		obj.createSchema();
	}
}
