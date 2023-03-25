<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h2>INDIE</h2>
	<form action="verifying" method = "post">
	Email<input type = "text" name = "email" />
	Password <input type = "text" name = "password"/>
	<input type = "submit" value = "login">
	</form>
	<%
	if(request.getAttribute("error")!=null){
		out.println(request.getAttribute("error"));	
		}
	
	%>
</body>
</html>