package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Approach2 extends HttpServlet {
	private static final String QUERY = "INSERT INTO MARRIAGE VALUES(MARRIAGEID.NEXTVAL,?,?,?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Write the logic for handling request
		// set response content type
		res.setContentType("text/html");
		// get print writer object
		PrintWriter pw = res.getWriter();
		// get the ServletConfig object
		//ServletConfig cg = getServletConfig();
		// Load the Driver Class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // try
		catch (ClassNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} // catch
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","advjava","tiger");
				PreparedStatement ps = con.prepareStatement(QUERY); ){
			// Set values to the query
			if(ps!=null) {
				// get the form values
				String firstName = req.getParameter("fname");
				String lastName = req.getParameter("lname");
				long phoneNumber = Long.parseLong(req.getParameter("pno"));
				String email = req.getParameter("email");
				int age = Integer.parseInt(req.getParameter("age"));
				String gender = req.getParameter("gender");
				String hobbies = req.getParameter("hobbies");		
				
				// Set the values
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setLong(3, phoneNumber);
				ps.setString(4, email);
				ps.setInt(5, age);
				ps.setString(6, gender);
				ps.setString(7, hobbies);
			} // if
			// Execute the query
			int result = ps.executeUpdate();
			if(result!=0)
				pw.println("<h1 style='color:red' align='center' >Successfully Registered</h1>");
			else
				pw.println("<h1 style='color:red' align='center' >problem in  Registration</h1>");
			pw.println("<a style='color:red' align='center' href='home.html'>Home</a>");
		} // try
		catch (SQLException e) {
			// handle exception
			e.printStackTrace();
		} // catch
	} // doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if post request came
		doGet(req, resp);
	} // doPost(-,-)
} // class
