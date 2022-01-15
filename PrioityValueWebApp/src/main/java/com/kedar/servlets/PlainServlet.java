package com.kedar.servlets;
 
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PlainServlet extends HttpServlet {
	static {
		System.out.println("PlainServlet.static()");
	} // static
	public PlainServlet() {
		// constructor stub
		System.out.println("PlainServlet.PlainServlet() :: 0 param constructor");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("PlainServlet.init(ServletConfig cg)");
	} // init(-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set content type
		res.setContentType("text/plain");
		// Get PrintWriter 
		PrintWriter pw = res.getWriter();
		// Provide response to the browser
		pw.println("<h1>Plain Servlet with Content type as Plain</h1>");
		// close the Stream
		pw.close();
	} // doGet(-,-)
} // class
