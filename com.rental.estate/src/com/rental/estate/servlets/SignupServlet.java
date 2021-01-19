package com.rental.estate.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.estate.dao.Broker;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String mob = request.getParameter("phone");
		
		Broker b = new Broker();
		Boolean r=false;
		
		
		
			if(name!="" && email!="" && pass!="" && mob!="") {
				
				if(mob.length()==10) {
				
				if(!b.CheckEmail(email)) {
				r = b.BrokerSignUp(email, pass, name,mob);
				
						if(r) {
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							rd.forward(request, response);
						}else {
							RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
							request.setAttribute("msg", "Error");
							rd.forward(request, response);
						}
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				request.setAttribute("msg", "Email already exist.");
				rd.forward(request, response);
				
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			request.setAttribute("msg", "Mobile Number should be of 10 digits.");
			rd.forward(request, response);
			
		}
		
			
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			request.setAttribute("msg", "Please fill all fields.");
			rd.forward(request, response);
		}
	}

}
