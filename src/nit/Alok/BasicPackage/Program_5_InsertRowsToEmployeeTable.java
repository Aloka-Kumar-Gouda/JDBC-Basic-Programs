package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program_5_InsertRowsToEmployeeTable {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "alokjdbc";
	String dbPwd = "akj";
	
	void insertRows() {
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			Statement stmt = conn.createStatement();
			
			IO.println("Executing InsertRow Queries---");
			int rowsInserted = 0;
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Kishan', 'Basina', 55000, 'Hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Raju', 'messa', 29000, 'hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'John', 'Wick', 30000, 'NIT')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Rani', 'robbi', 10000, 'Elr')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Ajinkya', 'Mule', 50000, 'Pune')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Wilson', 'Chris', 60000, 'Hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Deepak', 'Rathod', 25000, 'hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(employee_seq.nextval, 'Sujatha', 'Basina', 95000, 'hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(201, 'Prabhu', 'Deva', 20000, 'Hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(202, 'Om', 'Pandey', 35000, 'hyd')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(203, 'Cristine', 'june', 30000, 'hyd')
												""");
			
			IO.println(rowsInserted + " rows are Inserted.");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Program_5_InsertRowsToEmployeeTable obj = new Program_5_InsertRowsToEmployeeTable();
		obj.insertRows();
	}
}
