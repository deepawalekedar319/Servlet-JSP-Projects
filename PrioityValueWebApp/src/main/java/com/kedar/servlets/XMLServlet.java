package com.kedar.servlets;
 
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class XMLServlet extends HttpServlet {
	static {
		System.out.println("XMLServlet.static()");
	} // static
	public XMLServlet() {
		// constructor stub
		System.out.println("XMLServlet.XMLServlet() :: 0 param constructor");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("XMLServlet.init(ServletConfig cg)");
	} // init(-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set content type
		res.setContentType("text/html");
		// Get PrintWriter 
		PrintWriter pw = res.getWriter();
		// Provide response to the browser
		pw.println("<h1>XML Servlet with Content type as XML</h1>");
		// close the Stream
		pw.close();
	} // doGet(-,-)
} // class
