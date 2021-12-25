package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AllEmployees extends HttpServlet {
	private static final String QUERY = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMPTABLE";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AllEmployees.doGet()");
		// get ServletConfig object
		ServletContext cg = getServletContext();
		// set response Content type
		resp.setContentType("text/html");
		// get the stream
		PrintWriter pw = resp.getWriter();
		// get the request data
		try {
			Class.forName(cg.getInitParameter("dbClass"));
		} // try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		try (Connection con = DriverManager.getConnection(cg.getInitParameter("dbUrl"),cg.getInitParameter("dbUserName"),cg.getInitParameter("dbPassword"));
				PreparedStatement ps = con.prepareStatement(QUERY);){
				// Executing the query 
			if(ps!=null) {
				try (ResultSet rs = ps.executeQuery();){
					if(rs!=null) {
						pw.println("<table align=center border=3>");
						pw.println("<tr>");
						pw.println("<th>Name </th>");
						pw.println("<th>Salary </th>");
						pw.println("<th>Job </th>");
						pw.println("<th>Department </th>");
						pw.println("</tr>");
						while(rs.next()) {
							pw.println("<tr>");
							pw.println("<td>"+ rs.getString(2) + " </td>");
							pw.println("<td>"+ rs.getFloat(4) + " </td>");
							pw.println("<td>"+ rs.getString(3) + " </td>");
							pw.println("<td>"+ rs.getString(5) + " </td>");
							pw.println("</tr>");
							
						} // while
						pw.println("</table>");
					} // if
					else
						pw.println("Enter the correct ID...");
					pw.println("<a href='home.html'>Home</a>");
				} // try
				catch (SQLException e) {
					// handle exception
					e.printStackTrace();
				} // catch
			} // if				
		} // try 
		catch (Exception e) {
			// handle exception
			e.printStackTrace();
		} // catch
		// close the stream
		pw.close();
	} // doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	} // doPost(-,-)
} // class
