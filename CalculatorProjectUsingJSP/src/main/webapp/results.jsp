<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results Page </title>
</head>
<body>
		<%! int result = 0; %>
		<% int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
		String operation = request.getParameter("operation");
		%>
		
		<%! public int sumResult(int a, int b){
					return a+b;
		} // add
		 public int subResult(int a, int b){
				return a-b;
		} // sub
		 public int mulResult(int a, int b){
				return a*b;
		} // mul
		 public int divResult(int a, int b){
				return a/b;
		} // div
		%>
		<%
			if(operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("addition")) {
				result = sumResult(firstNumber, secondNumber);
			} // if
			else if(operation.equalsIgnoreCase("sub") || operation.equalsIgnoreCase("subtraction")) {
				result = subResult(firstNumber, secondNumber);
			} // else if
			else if(operation.equalsIgnoreCase("mul") || operation.equalsIgnoreCase("multiplication")) {
				result = mulResult(firstNumber, secondNumber);
			} // else if
			else if(operation.equalsIgnoreCase("div") || operation.equalsIgnoreCase("division")) {
				result = divResult(firstNumber, secondNumber);
			} // else if
			else {
				out.println("<h1 align='center'>Please enter the correct operation...</h1>");
			}
		%>
		<h1 align="center">Result is :: <%=result %></h1> 
		<a href='calculator.jsp'><h1 align="center">Home</h1></a>
</body>
</html>