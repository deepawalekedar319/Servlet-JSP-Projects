<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index.jsp File</title>
</head>
<body>
	<h1>This is index.jsp file...</h1>
	<h2>This file is present in Private Area and we are accessing it through web.xml</h2>
	
	<% out.println("This is sample Scriplet from JSP...."); %> <br>
	
	<%= "This is Expressing tag" %>
</body>
</html>