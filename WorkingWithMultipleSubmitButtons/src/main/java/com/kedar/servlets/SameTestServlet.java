package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SameTestServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Business Logic
		// Set response Content type
		res.setContentType("text/html");
		// get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		// Gather The result form the from 
		String resp = req.getParameter("s1");
		int val1=0,val2=0;
		if(!resp.equalsIgnoreCase("datetime") && !resp.equalsIgnoreCase("wish")) {
			val1 = Integer.parseInt(req.getParameter("value1"));
			val2 = Integer.parseInt(req.getParameter("value2"));
		}
			if(resp.equalsIgnoreCase("Add"))
				pw.println("<h1> Addition of the given values are :: " + (val1+val2) + " </h1>");
			else if(resp.equalsIgnoreCase("Sub"))
				pw.println("<h1> Subtraction of the given values are :: " + (val1-val2) + " </h1>");
			else if(resp.equalsIgnoreCase("Mul"))
				pw.println("<h1> Multiplication of the given values are :: " + (val1*val2) + " </h1>");
			else  if(resp.equalsIgnoreCase("Div"))
				pw.println("<h1> Division of the given values are :: " + (val1/val2) + " </h1>");
			else  if(resp.equalsIgnoreCase("datetime"))
				pw.println("<h1> Server Date and Time is  :: " + LocalDateTime.now() + " </h1>");
			else
				pw.println("<h1> Multiplication of the given values are :: Wish is for you...  </h1>");
	} // doGet(-,-)
} // class
