package com.rental.estate.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;




public class ConnectionFactory {
	
	
	
	 private Connection connect = null;
	
	  
	  public  Connection getConnection() {
		  
		    try {
		    	
		      // This will load the MySQL driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ozark","root","root");
		      return connect;
		      
		      }
		    catch (Exception e) {
				
		    	System.out.print(e.getMessage());
		    	return null;
			}
	    
	  }
	  
	 

}
