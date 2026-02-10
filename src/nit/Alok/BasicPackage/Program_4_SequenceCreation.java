package nit.Alok.BasicPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program_4_SequenceCreation {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:free";
	String dbUname = "alokjdbc";
	String dbPwd = "akj";
	
	void createSequence() {
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			Statement stmt = conn.createStatement();
			
			/*IO.println("Executing Sequence Creation Query in StringBuilder Style");
			
			String seqName = "employee_seq";
			int start = 1;
			
			StringBuilder sb = new StringBuilder();
			sb.append("create sequence ").append(seqName).append("\n");
			sb.append("start with ").append(start).append("\n");
			sb.append("increment by 1");
			stmt.execute(sb.toString());
			IO.println("Sequence Created to Employee Table.");*/
			
			/*StringBuilder is not mandatory for creating a sequence in JDBC.
			  It is used to build dynamic or multi-line SQL queries efficiently and improve readability.
			  JDBC ultimately executes only the final String query.
			  To execute a dynamically created sequence SQL in JDBC, -
			  -convert the StringBuilder to String using toString() and execute it using Statement.execute() method.
			  String is used when the data is fixed and does not change, -
			  -whereas StringBuilder is used when the data is modified frequently or built dynamically.*/
			
			/*database + JDBC do NOT care whether the string came from:
			  String
			  StringBuilder
			  Text block (""" """)
			  String is immutable
			  Every + creates a new object
			  StringBuilder modifies the same object*/
			
			IO.println("Executing Sequence Creation Query in String Style");
			String employeeTableSequenceQuery = """
													create sequence employee_seq
													start with 101
													increment by 1
												""";
			
			stmt.execute(employeeTableSequenceQuery);
			IO.println("Sequence Created to Employee Table.");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Program_4_SequenceCreation obj = new Program_4_SequenceCreation();
		obj.createSequence();
	}
}
