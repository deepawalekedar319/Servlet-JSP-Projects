package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/resultsServlet")
public class ResultClassServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// method stub
		
		// set the response content type
		resp.setContentType("text/html");
		
		// get the Stream object
		PrintWriter pw = resp.getWriter();
		
		// get the data from the request parameter object
		int firstNumber = Integer.parseInt(req.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt(req.getParameter("secondNumber"));
		
		//  get the operation type
		String operation = req.getParameter("operation");
		
		// var for storing result
		int result = 0;
		// logic
		if(operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("addition")) {
			result = firstNumber + secondNumber;
		} // if
		else if(operation.equalsIgnoreCase("sub") || operation.equalsIgnoreCase("subtraction")) {
			result = firstNumber - secondNumber;
		} // else if
		else if(operation.equalsIgnoreCase("mul") || operation.equalsIgnoreCase("multiplication")) {
			result = firstNumber * secondNumber;
		} // else if
		else if(operation.equalsIgnoreCase("div") || operation.equalsIgnoreCase("division")) {
			result = firstNumber / secondNumber;
		} // else if
		else {
			pw.println("<h1 align='center'>Please enter the correct operation...</h1>");
		}
		
		// providing the response to the browser
		pw.println("<h1 align='center' > Result is :: " + result + "</h1>");
		pw.println("<a href='calculator.jsp'><h1 align='center'>Home</h1></a>");
		
	} // doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method stub
		doGet(req, resp);
	} // doPost(-,-)
} // class