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
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet(-,-) method logic
		// set content type
		resp.setContentType("text/html");
		// get PrintWriter Stream object
		PrintWriter pw = resp.getWriter();
		// Gathering the form data from the req object
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		
		// Validation logic
		List<String> errorList = new ArrayList<String>();
		if(name.equalsIgnoreCase("") || name==null || name.length()==0) 
			errorList.add("Name field required");
		if(email.equalsIgnoreCase("") || email==null || email.length()==0) 
			errorList.add("Email field required");
		if(phone.equalsIgnoreCase("") || phone==null || phone.length()==0) 
			errorList.add("Phone number is required");
		if(errorList.size()>0) {
			for(String error:errorList)
				pw.println(error);
		} // if
		// close the stream
		pw.close();
	} // doGet(-,-)
} // class
