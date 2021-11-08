package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// service method
		// set response content
		res.setContentType("text/html");
		// get PrintWriter stream object
		PrintWriter pw = res.getWriter();
		// Business logic
		pw.println("<h1>Sample Test in new Workspace");
		// close stream
		pw.close();
	} // service(-,-)
} // class
