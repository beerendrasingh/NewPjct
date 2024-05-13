package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToFetchData {
	
	public static void main(String[] args) throws SQLException {
		// step1: load or register the database driver
		Driver driverRef =new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: connect to database
		
		Connection conn = DriverManager.getConnection( ,"root","root");
		
		System.out.println("====Done===");
		
		//step3: create sql statement
		
		  Statement stat=  conn.createStatement();
		   
		 //step4: execute select query
		  
		ResultSet resultSet = stat.executeQuery("select* from project");
		    while(resultSet.next()) {
		    	System.out.println(resultSet.getString(1)+ "\t"+resultSet.getString(2));
		    }
		
		//step5: close the connection
		
		conn.close();
		
		
		
		
		
	}
	
	

}
