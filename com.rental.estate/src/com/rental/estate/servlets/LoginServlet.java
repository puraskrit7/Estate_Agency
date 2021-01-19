package com.rental.estate.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.estate.dao.Broker;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		Broker b = new Broker();
		Boolean r=false;
		if( email!="" && pass!="") {
			r = b.BrokerLogin(email, pass);
			
			if(r) {
				ResultSet rs = b.BrokerDetails(email, pass);
				String name="";
				
				
				
				try {
					rs.next();
					name = rs.getString(2);
					request.setAttribute("name", name);
					request.setAttribute("id", rs.getString(1));
					request.setAttribute("mb", rs.getString(5));
					ResultSet properties = b.getProperty(rs.getInt(1));
					request.setAttribute("property", properties);
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				RequestDispatcher rd = request.getRequestDispatcher("brokerHome.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Invalid Credentials");
				rd.forward(request, response);
			}
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "Please fill all fields.");
			rd.forward(request, response);
		}
		
	}

}
