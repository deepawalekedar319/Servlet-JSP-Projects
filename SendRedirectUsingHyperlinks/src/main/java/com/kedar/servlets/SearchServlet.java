package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		// Logic
		
		// set response content type
		resp.setContentType("text/html");
		// get PrintWriter object
		PrintWriter ps = resp.getWriter();
		
		// get the query String
		String queryString = req.getParameter("string");
		
		// get the Search Engine
		String engine = req.getParameter("engine");
		
		
		// Selecting the search engine
		if(engine.equalsIgnoreCase("google"))
			ps.println("<a href='https://www.google.com/search?q="+queryString+"'Click here for google search</a><br>");

		else if(engine.equalsIgnoreCase("bing"))
			ps.println("<a href='https://www.bing.com/search?q="+queryString+"'Click here for bing search</a><br>");
		else
			ps.println("<a href='https://in.search.yahoo.com/search;_ylt="+queryString+"'Click here for yahoo search</a> <br>");
		ps.println("<br><h1 align='center'> Please click to start searching process...</h1");
			
		// close the stream
		ps.close();
	} // doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doPost(-,-)
	doGet(req, resp);
	} // doPost(-,-)
} // class
