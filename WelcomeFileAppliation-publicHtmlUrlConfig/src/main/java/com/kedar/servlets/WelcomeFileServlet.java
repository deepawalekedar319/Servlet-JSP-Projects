package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WelcomeFileServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Welcome file Application business logic
		// Set content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		// Response to the browser
		pw.println("<h1 style='text-align:center'> Welcome File Application </h1>");
		pw.println("<a href='home' style='text-align:center'> Welcome File Application </a>");
		// Closing the stream
		pw.close();
	} // doGet(-,-)
} // class
