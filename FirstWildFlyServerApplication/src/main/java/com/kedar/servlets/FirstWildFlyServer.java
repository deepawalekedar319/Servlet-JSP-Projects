package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstWildFlyServer  extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set response content type
		resp.setContentType("text/html");
		// get Writer
		PrintWriter pw = resp.getWriter();
		// Write the business logic
		pw.println("<h1> WildFly Server First application...</h1>");
		pw.println("<a href='home.html'>Home...</a>");
		// close stream
		pw.close();
	} // doGet(-,-)
} // class
