package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmployeeDataServlet extends HttpServlet {
	private static final String query = "select ename,sal from emp where EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Write the logic...
		// set response content type
		resp.setContentType("text/html");
		// get print writer object
		PrintWriter pw = resp.getWriter();
		// write the logic...
		int id = Integer.parseInt(req.getParameter("id"));
		// Load Driver Class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // try
		catch (ClassNotFoundException cfe) {
			// handle exception
			cfe.printStackTrace();
		} // catch
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","xe","tiger");
				PreparedStatement ps = con.prepareStatement(query);){
					// Set the parameter
			ps.setInt(1, id);
			// execute the query
			try (ResultSet rs = ps.executeQuery()){
				if(rs!=null) {
					if(rs.next()) {
						pw.println("<table align=center border=2>");
						pw.println("<tr>");
						pw.println("<td>Name :: "+ rs.getString(1)+" </td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td>Salary :: "+ rs.getFloat(2)+" </td>");
						pw.println("</tr>");
						pw.println("</table>");
					} // while
					else {
						pw.println("<h1>Employee does not exist...</h1>");
					} // else
				} // if
			} // try
			catch (SQLException e) {
				// handle exception
				e.printStackTrace();
			} // catch
		} // try
		catch (SQLException e) {
			// handle exception
			e.printStackTrace();
		} // catch
		pw.println("<a href='home.html'>Home...</a>");
		// close Stream
		pw.close();
	} // doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if post request came...
		doGet(req, resp);
	} // doPost(-,-)
} // class
