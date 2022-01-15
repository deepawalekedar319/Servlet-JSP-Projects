package com.kedar.servlets;
 
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ExcelServlet extends HttpServlet {
	static {
		System.out.println("ExcelServlet.static()");
	} // static
	public ExcelServlet() {
		// constructor stub
		System.out.println("ExcelServlet.ExcelServlet()");
	} // Constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		// init(-) method stub
		System.out.println("ExcelServlet.init(-)");
	} // init(-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set content type
		res.setContentType("application/vnd.ms-excel");
		// Get PrintWriter 
		PrintWriter pw = res.getWriter();
		// Provide response to the browser
		pw.println("<h1>Excel Servlet with Content type as Excel</h1>");
		// close the Stream
		pw.close();
	} // doGet(-,-)
} // class
