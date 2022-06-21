<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter you details </title>
</head>
<body>
	<% out.println("<h1> Server Date and Time is :: " + new java.util.Date() + "<h1>");%>
	<h1 align="center"><u>Enter your Details :: </u></h1>
	<form action="second.jsp">
		<table align="center" bgcolor="cyan" border=20>
		<tr>
			<td>Enter Name :: </td>
			<td><input type="text" name="name"> </td>
		</tr>
		<tr>
			<td>Enter Age ::</td> 
			<td><input type="text" name="age"></td> <br>
		</tr>
		<tr>
			<td align="Center"><input type="reset" value="Reset"></td> 
			<td align="Center"><input type="submit" value="Submit"></td> <br>
		</tr>	
		</table>
	</form>
</body>
</html>