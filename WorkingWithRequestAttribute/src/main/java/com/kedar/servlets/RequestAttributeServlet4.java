package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/servlet4")
public class RequestAttributeServlet4 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet(-,-) logic
		
		// set response content type
		resp.setContentType("text/html");
		// get the PrintWriter object
		PrintWriter pw = resp.getWriter();
	
		// Accessing the request attribute in Servlet 4
		pw.println("<h1> This is the request attribute from Servlet - 3 :: " + req.getAttribute("attribute1"));
		
		// close the Stream
		pw.close();
		
	} // doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// when post request has came 
		doGet(req, resp);
	} // doPost(-,-)	 
} // class