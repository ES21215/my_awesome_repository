<!--Etti Sherman-->
<%@ page language="java" 
		  contentType="text/html; charset=utf-8"
    	  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
	<head>
		<meta charset="utf-8">
		<style>table,td,th {border: 1px solid black;} </style>
		<title>Homework #2</title>
	</head>
	<body>
		<table>
		<tr>
		<% for (int heading = 1; heading <= 10; heading++)
		   { %>
			<th>Column <%=heading %> </th>
		<% } %>
		</tr>
		<% for(int row = 1; row <= 25; row++)
		   { %>
		<tr>
			<% for(int col = 1; col <= 10; col++)
			   { %>
				<td>Row <%=row%> Col <%=col%></td>
			<% } %>	
		</tr>
		<% } %>
		</table>
	</body>
</html>