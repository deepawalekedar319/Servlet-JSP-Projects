package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SampleTestForNewWorkSpace extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Sample test with new workspace
		// Set Content type
		res.setContentType("text/html");
		// get the response object
		PrintWriter pw = res.getWriter();
		// Set Browser Content type
		pw.println("Hello world");
		// close stream
		pw.close();
	} // service(-,-)
} // class
