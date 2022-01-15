package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServerSideFormValidationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Validation logic  the form
		// Set content type
		res.setContentType("text/html");
		// Get PrintWriter object from the Response object
		PrintWriter pw = res.getWriter();
		// Gathering the data form the form which is stored into the request object
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		// Validation logic
		List<String> errorList = new ArrayList<String>(); 
		if(name==null || name.length()==0 || name.equalsIgnoreCase(""))
					errorList.add("Name field is required"); // required rule for name
		else if(name.length()>20) // Maximum length  for name 
			errorList.add("Name cannot exceeds more than 20 characters");
		if(email==null ||email.length()==0 || email.equalsIgnoreCase(""))
			errorList.add("Email field is required"); // required rule for email
		if(age==null || age.length()==0 || age.equalsIgnoreCase(""))
			errorList.add("Age field is required"); // required rule for age
		else {
			try {
				if(Integer.parseInt(age)<0 || Integer.parseInt(age)>125)
					errorList.add("Age cannot exceeds 125 years"); 
			} // try
			catch (NullPointerException npe) {
				// handle exception
				errorList.add("Age must be numeric value"); 
			} // catch
		} // else
		if(phone==null || phone.length()==0 || phone.equalsIgnoreCase(""))
			errorList.add("Phone number is required"); // required rule for phone
		else {
			long num = Integer.parseInt(phone);
			try {
				if(num<0 || num>10)
					errorList.add("Phone number cannot exceeds more than 10 digits");
			} // try 
			catch (NullPointerException npe) {
				// handle exception
				errorList.add("Phone number must be a numeric value");
			} // catch
		} // else
		if(gender==null || gender.length()==0 || gender.equalsIgnoreCase(""))
			errorList.add("Specify the gender");
		
		if(errorList.size()>0) {
			pw.println("<ul style='color:red;'>");
			for(String err:errorList)
				pw.println("<li> " + err + "</li>");
			pw.println("</ul><br>");
			pw.println("<a href='home'>Home</a>");
			return; // blocking control going further 				
		} // if
		// Providing the response to the browser
		pw.println("<h1> Hello...  " + name + "<br>Your Email is... " + email + "<br>Gender is... " + gender + "</h1>");
		pw.println("<a href='home'>Home</a>");
		// Closing the Stream
		pw.close();
	} // doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// If post request has come
		doGet(req, resp);
	} // doPost(-,-)
} // class
