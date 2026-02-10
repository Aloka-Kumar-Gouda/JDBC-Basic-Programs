package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program_3_TableCreation {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "alokjdbc";
	String dbPwd = "akj";
	
	void createTable() {
		try
		{
			Class.forName(driver);
			IO.println("Driver is Loaded.");
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("Connection is Established.");
			Statement stmt = conn.createStatement();
			IO.println("Statement is Created.\n");
			
			// *Preparing Queries for Creating Tables*
			String employeeTableQuery = """
											create table employee (
											EID varchar2(20) primary key not null,
											EFNAME varchar2(20),
											ELNAME varchar2(20),
											ESAL number(10),
											EADDRESS varchar2(20)
											)
										""";
			
			// *Executing Above Queries*
			stmt.execute(employeeTableQuery);
			IO.println("Employee Table Created.\n");
			
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
		Program_3_TableCreation obj = new Program_3_TableCreation();
		obj.createTable();
	}
}
