package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get PrintWriter 
		PrintWriter pw = resp.getWriter();
		// set the response content type
		resp.setContentType("text/html");
		pw.println("<h1>Welcome to Windows 10 with new Eclipse setup...");
		// close the stream
		pw.close();
	} // doGet(-,-)
} // class
