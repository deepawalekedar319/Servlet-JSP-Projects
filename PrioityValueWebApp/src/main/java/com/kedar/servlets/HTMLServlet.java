package com.kedar.servlets;
 
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HTMLServlet extends HttpServlet {
	static {
		System.out.println("HTMLServlet.static()");
	} // static
	public HTMLServlet() {
		// constructor stub
		System.out.println("HTMLServlet.HTMLServlet()");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		// init(-)
		System.out.println("HTMLServlet.init()");
	} // init(-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set content type
		res.setContentType("text/html");
		// Get PrintWriter 
		PrintWriter pw = res.getWriter();
		// Provide response to the browser
		pw.println("<h1>HTML Servlet with Content type as HTML</h1>");
		// close the Stream
		pw.close();
	} // doGet(-,-)
} // class
