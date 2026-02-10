package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Program_7_PrintColumnInformationWithRows {
	
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
	void printColumnInformation() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			
			// Preparing Select Query !!!
			String selectQuery = """ 
									select EID, EFNAME, ELNAME, ESAL, EADDRESS
									from employee
									order by EID
								 """;
			
			// Executing the above Select Query and obtaining ResultSet(rs) Object---
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			// Obtaining ResultSetMetaData(rsmd) Object from ResultSet(rs) Object---
			ResultSetMetaData rsmd = rs.getMetaData();
			
			IO.println("Printing Column's Information of employee Table---");
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				IO.println(rsmd.getColumnName(i) + "\t\t" + rsmd.getColumnTypeName(i) + "(" + rsmd.getPrecision(i) + ")");				
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// 3>>>
	void printColumnInformationWithRows() {
		try
		{
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// Fetching Columns(rsmd) and Rows(rs)---
			int rowsSelected = 0;
			if(rs.next()) {
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					IO.print(rsmd.getColumnName(i) + "\t\t");
				}
				IO.println("\n-------------------------------------------------------------------------------------");
				
				do {
					for(int i = 1; i <= rsmd.getColumnCount(); i++) {
						IO.print(rs.getString(i) + "\t\t");
					}
					IO.println();
					rowsSelected += 1;
				}
				while(rs.next());
				IO.println("\n" + rowsSelected + " rows selected.");
			}
			else {
				IO.println("no rows selected.");
			}
			
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
		Program_7_PrintColumnInformationWithRows obj = new Program_7_PrintColumnInformationWithRows();
		obj.printColumnInformation();
		IO.println("\n");
		obj.printColumnInformationWithRows();
	}
}
