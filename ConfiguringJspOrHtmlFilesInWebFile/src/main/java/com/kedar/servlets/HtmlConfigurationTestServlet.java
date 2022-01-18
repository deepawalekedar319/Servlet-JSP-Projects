package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/newResponseFile")
public class HtmlConfigurationTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  method stub
		// get the PrintWriter 
		PrintWriter pw = resp.getWriter();
		// Set the response Content type
		resp.setContentType("text/html");
		// Provide the response
		pw.println("<h1> You have successfully configured the html file in web.xml</h1>");
		// close the stream
		pw.close();
	} // doGet(-,-)
} // class
