package com.rental.estate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rental.estate.DBHelper.ConnectionFactory;

public class Broker {
	
	PreparedStatement ps = null;
	ConnectionFactory cf = new ConnectionFactory();
	Connection c = cf.getConnection();
	
	public boolean BrokerLogin(String username, String pass) {
		String sql = "select * from broker_login_details where email = ? and password = ?";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
	
			if(rs.next()) {
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
	
	public ResultSet BrokerDetails(String username, String pass) {
		String sql = "select * from broker_login_details where email = ? and password = ?";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
	
			return rs;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public boolean CheckEmail(String email) {
		String sql = "select * from broker_login_details where email = ?";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, email);
		
			
			ResultSet rs = ps.executeQuery();
	
			if(rs.next()) {
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
	
	
	public boolean BrokerSignUp(String username, String pass,String name,String mob) {
		String sql = "insert into broker_login_details(name,email,password,mobile) values(?,?,?,?)";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, pass);
			ps.setString(4, mob);
			
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
	

	
	public boolean addProperty(int bId,String bMobile,String desc,String price,String url,String address) {
		
		String sql = "insert into property(broker_id,broker_mobile,property_desc,price,url,address) values(?,?,?,?,?,?)";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, bId);
			ps.setString(2, bMobile);
			ps.setString(3, desc);
			ps.setString(4, price);
			ps.setString(5, url);
			ps.setString(6, address);
			
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
	
public ResultSet getProperty(int bId) {
		
		String sql = "Select * from property where broker_id=?";
		
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, bId);
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
		return null;
		
	}

public ResultSet getLeads(int bId) {
	
	String sql = "Select * from leads where broker_id=?";
	
	try {
		ps = c.prepareStatement(sql);
		ps.setInt(1, bId);
		
		ResultSet rs = ps.executeQuery();
		
		return rs;
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	
	return null;
	
}
}
