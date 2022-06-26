<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body style="background:linear-gradient(to left,black,white,red);">
		<h1 align="center"><u>Calculator Project Using JSP concept </u> :: </h1>
		<form action="resultsServlet" method="post">
			<table align="center" bgcolor=cyan border="30">
				<tr>
					<td>Enter First Number :- </td>
					<td><input type="text" placeholder="Enter First Number" name="firstNumber" required="required"></td>
				</tr>
				<tr>
					<td>Enter Second Number :- </td>
					<td><input type="text" placeholder="Enter Second Number" name="secondNumber" required="required"></td>
				</tr>
				<tr>
					<td>Enter Operation :- </td>
					<td><input type="text" placeholder="Add/Sub/Mul/Div..." name="operation" required="required"></td>
				</tr>
				<tr>
					<td align="center"><input type="reset" value="Reset"></td>
					<td align="center"><input type="submit" value="Result"></td>
				</tr>
			</table>
		</form>
</body>
</html>