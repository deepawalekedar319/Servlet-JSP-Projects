package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class VaccineCheckServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// doGet(-,-)
		// Set Content Type
		res.setContentType("text/html");
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// read the date from the request object
		String name = req.getParameter("name");
		String location = req.getParameter("location");
		int age = Integer.parseInt(req.getParameter("age"));
		// providing the response to the browser
		if(age<18)
			pw.println("<h1 style='color:blue;'> Dear..." + name + " you are not eligibile for Vaccination...</h1>");
		else 
			pw.println("<h1 style='color:blue;'> Dear..." + name + " you are eligibile for Vaccination... and you can take your vaccine near " + location + " </h1>");
		pw.println("<a href='home.html'><img src='images/homeLogo.jpg' height='90px'> </a>");
		// closing Stream object
		pw.close();
	} // doGet(-,-)
} // class
