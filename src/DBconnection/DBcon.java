package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	
    public static Connection connect() {
		Connection connection = null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("DB not connected");
	}
	return connection;

	}
}
