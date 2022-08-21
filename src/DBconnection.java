import java.sql.*;
public class DBconnection {
	public static Connection mysqlcon() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz_App","root","root");
		return c;
		}
		catch(Exception e)
		{
			return null; 
		}
	}

}
