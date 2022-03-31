package com.kedar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/servlet")
public class FirstServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  method stub
		
		// set the response content type
		resp.setContentType("text/html");
		
		// get the print writer 
		PrintWriter pw = resp.getWriter();
		
		// get the from data
		String  status = req.getParameter("marriageStatus");
		
		// send the responses 
		if(status.equalsIgnoreCase("single")) {
			pw.println("<form action='secondServlet' method='get'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr>");
			pw.println("<td>When you want to marry :: </td>");
			pw.println(" <td><input type= 'text' name='secondform1' placeholder='Enter your answer'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>why do you want to marry :: </td>");
			pw.println(" <td><input type= 'text' name='secondform2' placeholder='Enter your answer'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td align='center'><input type= 'reset' value='Reset'></td>");
			pw.println(" <td align='center'><input type= 'submit' value='Submit'></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
		} // if
		else {
			pw.println("<form action='secondServlet' method='get'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr>");
			pw.println("<td>Spouse Name :: </td>");
			pw.println(" <td><input type= 'text' name='secondform1' placeholder='Enter your answer'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Number of childerns :: </td>");
			pw.println(" <td><input type= 'text' name='secondform2' placeholder='Enter your answer'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td align='center'><input type= 'reset' value='Reset'></td>");
			pw.println(" <td align='center'><input type= 'submit' value='Submit'></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
		} // else	   
		
		// home page link
		pw.println("<h3 align='center'><a href='home.html'> Home </a></h3>");
		
		// Close the stream
		pw.close();
	} // doGet(-,-)
} //class