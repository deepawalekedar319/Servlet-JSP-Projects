package com.kedar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// method stub
		
		// set the response content type
		response.setContentType("text/html");
				
		// get the print writer 
		PrintWriter pw = response.getWriter();
				
		// get the data from the form
		String name = request.getParameter("name");
		String ans1 = request.getParameter("secondform1");
		String ans2 = request.getParameter("secondform2");
		
		// Provide the response
		pw.println("<h1 align='center'>THANKS FOR REGISTRATION YOU WILL GET THE RESPONSE SOON....</h1> <br>");
		pw.println("Your name is :: " + name + "<br>");
		pw.println("Your responses from the second form is :: " + ans1 + "<br>");
		pw.println("Your responses from the second form is :: " + ans2 + "<br>");
	} //doGet(-,-)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} // doPost(-,-)
} // class
