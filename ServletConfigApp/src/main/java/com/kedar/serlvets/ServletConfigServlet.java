package com.kedar.serlvets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletConfigServlet extends HttpServlet {
	@Override
	public void init(ServletConfig cg) throws ServletException {
		// get the data from ServletConfig object
		System.out.println("Oracle Driver Class Name :: " + cg.getInitParameter("driverClass"));
		System.out.println("Oracle JDBC url :: " + cg.getInitParameter("jdbcUrl"));
		System.out.println("Oracle User :: " + cg.getInitParameter("dbUser"));
	} // init(-)
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Second service method
		// set content type
		res.setContentType("text/html");
		// get stream
		PrintWriter pw = res.getWriter();
		// write the business logic
		pw.println("<h1 style='align:center;color:red;'> ServletConfig sample project.... </h1>");
		// close stream
		pw.close();
	} // service(-,-)
} // class
