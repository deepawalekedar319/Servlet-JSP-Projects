package com.kedar.servlets;
 
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MSWordServlet extends HttpServlet {
	static {
		System.out.println("MSWordServlet.static()");
	} // static
	public MSWordServlet() {
		// constructor stub
		System.out.println("MSWordServlet.MSWordServlet() :: 0 param constructor");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MSWordServlet.init(ServletConfig cg)");
	} // init(-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set content type
		res.setContentType("application/msword");
		// Get PrintWriter 
		PrintWriter pw = res.getWriter();
		// Provide response to the browser
		pw.println("<h1>MSWord Servlet with Content type as MSWord</h1>");
		// close the Stream
		pw.close();
	} // doGet(-,-)
} // class
