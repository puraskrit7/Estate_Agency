package com.rental.estate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rental.estate.DBHelper.ConnectionFactory;

public class Property {
	PreparedStatement ps = null;
	ConnectionFactory cf = new ConnectionFactory();
	Connection c = cf.getConnection();
	
public ResultSet getAllProperty() {
		
		String sql = "Select * from property";
		
		try {
			ps = c.prepareStatement(sql);
		
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
		return null;
		
	}


public boolean sendLead(int brokerId,String name,String mobile) {
	
	String sql = "insert into leads(broker_id,name,mobile) values(?,?,?)";
	
	try {
		ps = c.prepareStatement(sql);
		ps.setInt(1, brokerId);
		ps.setString(2, name);
		ps.setString(3, mobile);
		
	
		
		int n = ps.executeUpdate();
		
		if(n>0) {
			return true;
		}
		else {
			return false;
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	
	return false;
}

}

