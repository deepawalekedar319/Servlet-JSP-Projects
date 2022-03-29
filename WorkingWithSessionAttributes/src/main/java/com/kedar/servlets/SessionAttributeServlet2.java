package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/servlet2")
public class SessionAttributeServlet2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  method stub Working with Session Attributes
		// set response content type
		resp.setContentType("text/html");
		
		// Create Session Attribute
		HttpSession hs = req.getSession();

		// Get the session Attribute
		String attr = (String)hs.getAttribute("attribute 1");
		
		// Printing the attribute
		// get print writer object
		PrintWriter pw = resp.getWriter();
		pw.println("The session attribute from Servlet 2 is :: " + attr);
		
		// Forwarding the request to other servlet
		// Create request dispatcher object
		RequestDispatcher rd = req.getRequestDispatcher("/servlet3");
		// Forward the request
		rd.forward(req, resp);
		
		// Close the Stream
		pw.close();
	} // doGet(-,-)
} // class