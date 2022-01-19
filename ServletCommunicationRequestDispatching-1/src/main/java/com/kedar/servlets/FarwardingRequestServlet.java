package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/searchEmployee")
public class FarwardingRequestServlet extends HttpServlet {
	private static final String QUERY = "	SELECT * FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the Stream
		PrintWriter pw = resp.getWriter();
		// set the content type
		resp.setContentType("text/html");
		// Establishing the connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // try
		catch (ClassNotFoundException e) {
			// catch block
			// Creating the RequestDispatcher object
			RequestDispatcher rd = req.getRequestDispatcher("/errorPage");
			rd.forward(req, resp);
			e.printStackTrace();
		} // catch
		// Establish the Connection
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				PreparedStatement ps = con.prepareStatement(QUERY);){
			// Get the I'd from the form
			int id = Integer.parseInt(req.getParameter("id"));
			// set the value to query
			if(ps!=null)
				ps.setInt(1, id);
			// Execute the query
			if(ps!=null) {
				ResultSet result = ps.executeQuery();
				if(result.next()) {
					pw.println("<table align='center' border='5'>");
					pw.println("<tr>");
					pw.println("<tr>");
					pw.println("<td>I'd :: </td>");
					pw.println("<td>" + result.getString(1) + " </td>");
					pw.println("</tr>");
					pw.println("<td>Name :: </td>");
					pw.println("<td>" + result.getString(2) + " </td>");
					pw.println("</tr>");
					pw.println("<tr>");
					pw.println("<td>Salary :: </td>");
					pw.println("<td>" + result.getString(6) + " </td>");
					pw.println("</tr>");
					pw.println("<tr>");
					pw.println("<td>Job :: </td>");
					pw.println("<td>" + result.getString(3) + " </td>");
					pw.println("</tr>");
					pw.println("<tr>");
					pw.println("<td>Department :: </td>");
					pw.println("<td>" + result.getString(8) + " </td>");
					pw.println("</tr>");
					pw.println("</table>");
				} // if
				else {
					RequestDispatcher rd = req.getRequestDispatcher("/errorPage");
					rd.forward(req, resp);
				} // else
			} // if
		} // try - 1
		catch (SQLException e) {
			// handle exception
			RequestDispatcher rd = req.getRequestDispatcher("/errorPage");
			rd.forward(req, resp);
			e.printStackTrace();
		} // catch
	} // doGet(-,-)
} // class
