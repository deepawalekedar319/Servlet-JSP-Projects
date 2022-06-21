<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details page</title>
</head>
<body>
		<h1>Hi... <%out.println("<h1> " + request.getParameter("name")+ ",<br> Your age is :: " + request.getParameter("age") + " years...</h1>"); %></h1>
		<a href="first.jsp">Home...</a>
</body>
</html>