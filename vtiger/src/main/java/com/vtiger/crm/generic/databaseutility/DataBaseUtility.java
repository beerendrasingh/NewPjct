package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DataBaseUtility {
	
	Connection conn;
	public void getDbconnection(String url , String username , String password){
	try {
	Driver driver = new Driver();
	
	DriverManager.registerDriver(driver);
	
	 conn = DriverManager.getConnection(url, username, password);
	
	}catch(Exception e) 
	{
		//TODO: handle exception
	}
		
	  }
	public void closeDbconnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
    public ResultSet executeSelectQuery(String query) {
       ResultSet resultset = null;
     try {
       Statement stat=conn.createStatement();
       resultset= stat.executeQuery(query);
     }catch (Exception e) {
		// TODO: handle exception
	}
      return resultset; 
               
    	
    }
		
	public int executeNonSelectQuery(String query)	{
		int result=0;
		try {
			Statement st =conn.createStatement();
			result= st.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public void getDbconnection()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jsbc:mysql//localhost:3306/projects", "root", "root");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
		
		
		
}
	
