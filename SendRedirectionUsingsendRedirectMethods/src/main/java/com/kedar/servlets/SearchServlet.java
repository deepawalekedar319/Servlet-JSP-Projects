package com.kedar.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Send Redirection using sendRedirect(-) method
		
		// set response content type
		resp.setContentType("text/html");
		
		// get the Search engine selected by the client
		String engine = req.getParameter("engine");
		// get the Client search String
		String searchString = req.getParameter("string");
		
		
		// Selecting and redirecting the control
		String url = null;
		if(engine.equalsIgnoreCase("google"))
			url = "https://www.google.com/search?q="+ searchString;
		else if(engine.equalsIgnoreCase("bing"))
				url = "https://www.bing.com/search?q="+ searchString;
		else
			url = "https://in.search.yahoo.com/search;_ylt=" + searchString;
		
		// Redirecting the request
		resp.sendRedirect(url);
		
	} // doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// When post request has came
		doGet(req, resp);
	} // doPost(-,-)
} // class
