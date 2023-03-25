<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<h2>UPDATE</h2>
	<form action="update" method = "post" >
	<table>
		
		<tr>
		<td> EMAIL</td>
		<td> <input type = "text" name = "email" value = "<%=request.getAttribute("email")%>"/></td>
		</tr>
		<tr>
		<td> MOBILE NUMBER</td>
		<td> <input type = "text" name = "mobile" value = "<%=request.getAttribute("mobile")%>"/></td>
		</tr>
		<tr>
		<td> <input type = "submit" value = "update"/></td>
		</tr>
	
	</table>
	</form>

</body>
</html>