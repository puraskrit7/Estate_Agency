package com.rental.estate.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.estate.dao.Property;


/**
 * Servlet implementation class contactServlet
 */
@WebServlet("/contactServlet")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String id = request.getParameter("brokerId");
		
		Property p = new Property();
		
		if(p.sendLead(Integer.valueOf(id), name, mobile)) {
			
			request.setAttribute("msg", "Notification sent Sucessfully");
			
			RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("msg", "Error sending notification");
			RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
