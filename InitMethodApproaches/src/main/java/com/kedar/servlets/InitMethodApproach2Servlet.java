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
public class InitMethodApproach2Servlet extends HttpServlet {
	private ServletConfig cg;
	// Servlet Life Cycle
	static {
		System.out.println("InitMethodApproach2Servlet.static() :: Servlet Loading...");
	} // static
	public InitMethodApproach2Servlet() {
		// constructor stub
		System.out.println("InitMethodApproach2Servlet.InitMethodApproach1Servlet() :: Servlet Instantation...");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		// super class
		cg = config;
		System.out.println("InitMethodApproach2Servlet.init(-) :: bad approach");
		System.out.println("DB url :: " + cg.getInitParameter("DBUrl"));
	} // init(-)
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// service(-,-)
		// set Http response Content type
		res.setContentType("text/html");
		// DB details
		System.out.println("DB url :: " + cg.getInitParameter("DBUrl"));
		// get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		// Write the output to the browser
		pw.println("<h1> Data and Time is :: " + LocalDateTime.now() +"</h1>");
	} // service(-,-)
} // class
