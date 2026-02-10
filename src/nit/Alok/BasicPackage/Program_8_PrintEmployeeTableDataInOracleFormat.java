package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Program_8_PrintEmployeeTableDataInOracleFormat {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "alokjdbc";
	String dbPwd = "akj";
	
	void printEmployeeData() {
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			Statement stmt = conn.createStatement();
			
			// Executing SELECT query and obtaining ResultSetMetaData(rsmd) object from ResultSet(rs) object
			ResultSet rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// Fetching Columns(rsmd) and Rows(rs)
			int colCount = rsmd.getColumnCount();
			
			// If no rows
			if(!rs.next()) {
				IO.println("No rows found.");
				conn.close();
				return;
			}
			
			// Print Column Names
			for(int i = 1; i <= colCount; i++) {
				int width = Math.max(rsmd.getColumnName(i).length(), rsmd.getPrecision(i));
				String type = rsmd.getColumnTypeName(i);
				
				if(type.equalsIgnoreCase("NUMBER")) {
					// Right align numeric column names (ESAL)
					IO.print(String.format("%" + width + "s ", rsmd.getColumnName(i)));
				}
				else {
					// Left align text column names
					IO.print(String.format("%-" + width + "s ", rsmd.getColumnName(i)));
				}
			}
			IO.println();
			
			// Print Separator Line
			for(int i = 1; i <= colCount; i++) {
				int width = Math.max(rsmd.getColumnName(i).length(), rsmd.getPrecision(i));
				IO.print(String.format("%-" + width + "s ", "-".repeat(width)));			
			}
			IO.println();
			
			// Printing Rows
			int rowsSelected = 0;
			do {
				for(int i = 1; i <= colCount; i++) {
					int width = Math.max(rsmd.getColumnName(i).length(), rsmd.getPrecision(i));
					String type = rsmd.getColumnTypeName(i);
					
					if(type.equalsIgnoreCase("NUMBER")) {
						IO.print(String.format("%" + width + "s ", rs.getInt(i))); // Right Alignment
					}
					else {
						IO.print(String.format("%-" + width + "s ", rs.getString(i))); // Left Alignment
					}
				}
				IO.println();
				rowsSelected +=1;
			}
			while(rs.next());
			
			// Show Row Count
			IO.println();
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
		Program_8_PrintEmployeeTableDataInOracleFormat obj = new Program_8_PrintEmployeeTableDataInOracleFormat();
		obj.printEmployeeData();
	}
}
