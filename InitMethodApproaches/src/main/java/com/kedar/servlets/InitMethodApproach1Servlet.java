package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class InitMethodApproach1Servlet extends HttpServlet {
	// Servlet Life Cycle
	static {
		System.out.println("InitMethodApproach1Servlet.static() :: Servlet Loading...");
	} // static
	public InitMethodApproach1Servlet() {
		// constructor stub
		System.out.println("InitMethodApproach1Servlet.InitMethodApproach1Servlet() :: Servlet Instantation...");
	} // constructor
	@Override
	public void init() throws ServletException {
		// Second init() method
		System.out.println("InitMethodApproach1Servlet.init() :: Second init() method...");
		System.out.println("Super class init(-) executes and perform all initalization...");
		// DB details
		ServletConfig cd = getServletConfig();
		System.out.println("DB url :: " + cd.getInitParameter("DBUrl"));
	} // init()
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// service(-,-)
		// set Http response Content type
		res.setContentType("text/html");
		// DB details
		ServletConfig cg = getServletConfig();
		System.out.println("DB url :: " + cg.getInitParameter("DBUrl"));
		// get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		// Write the output to the browser
		pw.println("<h1> Data and Time is :: " + LocalDateTime.now() +"</h1>");
	} // service(-,-)
} // class
