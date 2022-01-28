package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/getAllUsers")
public class AllUsersServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get PrintWriter object
		PrintWriter pw = resp.getWriter();
		// set the content type
		resp.setContentType("text/html");
		
		// Logic
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // try
		catch (Exception e) {
			//  handle exception
			e.printStackTrace();
		} // catch
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","advjava","tiger");
					PreparedStatement ps = con.prepareStatement("SELECT *  FROM MARRIAGE");	){
				// Execute the query
				try(ResultSet rs = ps.executeQuery();){
					while(rs.next()) {
						pw.println("<table border = \"5\" bgcolor=cyan align=center >");
						pw.println("<tr>");
						pw.println("<td> First Name :: </td>" );
						pw.println("<td>" + rs.getString(1) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Last Name :: </td>" );
						pw.println("<td>" + rs.getString(2) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Email  :: </td>" );
						pw.println("<td>" + rs.getString(3) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Phone :: </td>" );
						pw.println("<td>" + rs.getString(4) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Age :: </td>" );
						pw.println("<td>" + rs.getString(5) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Gender :: </td>" );
						pw.println("<td>" + rs.getString(6) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Occupation :: </td>" );
						pw.println("<td>" + rs.getString(7) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Salary :: </td>" );
						pw.println("<td>" + rs.getString(8) + "</td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Resume :: </td>" );
						pw.println("<td><a href="+"downloadingFiles?resumeID=" + rs.getInt(11) +  " > " + "Download Resume</a></td>");
						pw.println("</tr>");
						pw.println("<tr>");
						pw.println("<td> Photo :: </td>" );
						pw.println("<td><a href="+"downloadingFiles?photoID=" + rs.getInt(11) +  " > " + "Download Photo</a></td>");
						pw.println("</tr>");
						pw.println("</table>");			
						pw.println("<hr>");
					} // while
					pw.println("<h1 align='center'><a href='home.html'>Home</a></h1>");
				} // try
				catch(SQLException se) {
					se.printStackTrace();
				} // catch
			} // try
			catch (Exception e2) {
				// handle exception
				e2.printStackTrace();
			} // catch	
		// Close the Stream
		pw.close();
	} // doGet(-,-)
} // class