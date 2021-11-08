package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/links")
public class MultipleLinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Logic
		// Set Http Content type
		res.setContentType("text/html");
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// get the selected link
		String val = req.getParameter("val");
		if(val.equalsIgnoreCase("datetime")) {
			pw.println("<h1 style='color:red';align:'center'> Date and Time is ::"+LocalDateTime.now()+"</h1>");
		}
		else if(val.equalsIgnoreCase("datetime"))
			pw.println("<h1 style='color:Blue';align:'center'> This is Greed for </h1>");
		else
			pw.println("<h1 style='color:red';align:'center'> Your Task is to get job...</h1>");
		pw.println("<a style=align:'center' href='home.html'>Home</a>");
	}	// doGet(-,-) 
} // class
