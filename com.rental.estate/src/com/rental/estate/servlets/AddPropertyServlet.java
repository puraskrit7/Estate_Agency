package com.rental.estate.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.estate.dao.Broker;


@WebServlet("/AddPropertyServlet")
public class AddPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idd = request.getParameter("id");
		String mb = request.getParameter("mobile");
		
		String desc = request.getParameter("desc");
		
		String address = request.getParameter("address");
		String url = request.getParameter("url");
		String price = request.getParameter("price");
		String name = request.getParameter("name");
		
		request.setAttribute("name", name);
		request.setAttribute("mb", mb);
		request.setAttribute("id", idd);
		
		Broker b = new Broker();
		
		if(idd!="" && mb!="" && desc!="" && address!="" && url!="" && price!="" ) {
			
				int id = Integer.valueOf(idd);
				
				boolean result = b.addProperty(id, mb, desc, price, url, address);
				if(result) {
					RequestDispatcher rd = request.getRequestDispatcher("brokerHome.jsp");
					ResultSet properties = b.getProperty(id);
					request.setAttribute("property", properties);
					
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("brokerHome.jsp");
					request.setAttribute("msg", "Error");
					rd.forward(request, response);
				}
			
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("brokerHome.jsp");
			request.setAttribute("msg", "Please fill all fields.");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
