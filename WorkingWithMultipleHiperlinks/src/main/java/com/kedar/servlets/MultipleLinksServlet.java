package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MultipleLinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// logic for get request mode
		// Set Content type
		res.setContentType("text/html");
		// Get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		// Collect the Data from the form
		String link = req.getParameter("p1");
		// get all available locale
		Locale locales[] = Locale.getAvailableLocales();
		if(link.equalsIgnoreCase("language")) {
			for(Locale l : locales)
				pw.println("<li>" + l.getDisplayLanguage() + "</li>");
		} // if
		else if(link.equalsIgnoreCase("countries")) {
			for(Locale l : locales)
				pw.println("<li>" + l.getDisplayCountry() + "</li>");
		} // if
		else {
			pw.println("<h2> Current data and time is :: " + LocalDateTime.now());
		} // else
		// Adding home 
		pw.println("<a href='home.html'> Home </a>");
	} // doGet(-,-)
} // class
