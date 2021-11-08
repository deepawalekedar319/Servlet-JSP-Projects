package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ClientSideFormValidationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet(-,-) Method implementation
		// set content type
		resp.setContentType("text/html");
		// get PrintWriter Stream object
		PrintWriter pw = resp.getWriter();
		// Gather the form data from the req object
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		// providing the response to the browser
		pw.println("<title> " + name + "</title>");
		pw.println("<h1> Welcome " + name + " we will heartly invite you, </h1>");
		pw.println("<h1> your email is :: " + email + " we have verified your email as well, </h1>");
		pw.println("<h1>Your phone number is ::  " + phone + " we are happy to get in touch with you, </h1>");
		pw.println("<h1>Your a gender is   ::  " + gender + " your age is :: " + age + ". </h1><br><br>");
		pw.println("<a href='home.html' style='color:red;text-align:center'>Home</a>");
	} // doGet(-,-)
} // class
