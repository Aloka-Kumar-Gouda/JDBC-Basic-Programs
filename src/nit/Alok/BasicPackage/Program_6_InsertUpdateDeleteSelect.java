package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program_6_InsertUpdateDeleteSelect {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "alokjdbc";
	String dbPwd = "akj";
	
	// 1>>>
	Connection connect() {
		Connection conn = null;
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	// 2>>>
	void insertRows() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			
			IO.println("Executing InsertRow Queries---");
			int rowsInserted = 0;
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(306, 'Allu', 'Deva', 80000, 'Hyd')
											   """);

			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(409, 'Anubhav', 'Mohanty', 35000, 'ODI')
											   """);

			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(420, 'Babushan', 'Mohanty', 98000, 'ODI')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(520, 'Sai', 'Babu', 9000, 'HAR')
											   """);
			
			rowsInserted += stmt.executeUpdate("""
													insert into employee
													values(505, 'Suman', 'Pani', 37000, 'ODI')
											   """);

			IO.println(rowsInserted + " rows Inserted.");

			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// 3>>>
	void updateRows() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
				
			IO.println("Executing UpdateRow Queries---");
			int rowsUpdated = 0;
				
			rowsUpdated += stmt.executeUpdate("""
													update employee
													set ELNAME = 'Arjun'
													where EID = 306
											  """);
				
			rowsUpdated += stmt.executeUpdate("""
													update employee
													set ESAL = 100000
													where EFNAME = 'Anubhav'
											  """);
				
			rowsUpdated += stmt.executeUpdate("""
													update employee
													set ESAL = 25000
													where EID = 520
											  """);
				
			IO.println(rowsUpdated + " rows Updated.");
				
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	// 4>>>
	void deleteRows() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
						
			IO.println("Executing DeleteRow Queries---");
			int rowsDeleted = 0;
						
			rowsDeleted += stmt.executeUpdate("""
													delete from employee
													where EID = 520
											  """);
						
			rowsDeleted += stmt.executeUpdate("""
													delete from employee
													where ELNAME = 'Pani'
											  """);
						
			IO.println(rowsDeleted + " rows Deleted.");
						
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// 5>>>
	void selectRows() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			int rowsSelected = 0;
			
			IO.println("Executing SelectRow Queries---");
			String selectQuery = """ 
									select EID, EFNAME, ELNAME, ESAL, EADDRESS
									from employee
									order by EID
								 """;
			
			// Executing the above Select Query and Obtaining ResultSet(rs) Object---
			ResultSet rs = stmt.executeQuery(selectQuery);
			IO.println();
			// Retrieving results from DB by using rs Object
			IO.println("<------------------Table Data---------------------->");
			while(rs.next()) {
				IO.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getLong(4) + "\t" + rs.getString(5));
				rowsSelected +=1;
			}
			IO.println(rowsSelected + " rows selected.");
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Program_6_InsertUpdateDeleteSelect obj = new Program_6_InsertUpdateDeleteSelect();
		//obj.insertRows();
		//IO.println("\n");
		//obj.updateRows();
		//IO.println("\n");
		//obj.deleteRows();
		//IO.println("\n");
		obj.selectRows();
	}
}
