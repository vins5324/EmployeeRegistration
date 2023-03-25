<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all registration</title>
</head>
<body>
<% HttpSession sessio = request.getSession(false);
		if(sessio.getAttribute("email")!=null) {%>
	<h2>ALL REGISTRATION</h2>
	<form action="registration" method = "post" >
	<table>
		<tr>
		<th> NAME</th>
		<th> CITY</th>
		<th> Email</th>
		<th> MOBILE NUMBER</th>
		<th>Delete</th>
		</tr>
	<%
		ResultSet result = (ResultSet)request.getAttribute("result");
		while(result.next()){
		
	%>
		<tr>
		<td><%= result.getString(1) %></td>
		<td><%= result.getString(2) %></td>
		<td><%= result.getString(3) %></td>
		<td><%= result.getString(4) %></td>
		<td> <a href = "delete?mobile=<%= result.getString(4) %>">delete</a> </td>
		<td> <a href = "update?email=<%= result.getString(3) %>&mobile=<%=result.getString(4)%>">update</a> </td>
		</tr>
			
	<%}
	%>
	
	</table>
	</form>
	<%}else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
		dispatcher.forward(request, response);
		}%>
	
</body>
</html>