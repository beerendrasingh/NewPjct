package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertData {
	
	public static void main(String[] args) throws SQLException {
		// load or register the database driver
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		// get the connection to database
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("====done=====");
		
		// create an sql query
		
		Statement stat = conn.createStatement();
		
		// execute the query
		
		int result = stat.executeUpdate("insert in to project values('tp_4','beerendra','04/07/2000','vtiger1','ongoing',45)") ;
		System.out.println(result);
		conn.close();
		
		
		
		
	}

}
