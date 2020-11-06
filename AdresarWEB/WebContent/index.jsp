<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adresar</title>
</head>
<body>
	<form action="/AdresarWEB/AdresarServlet" method="post" >
		Ime: <input type="text" name="ime">
		<input type="submit" value="pronadji">
	</form>
	<% if(request.getAttribute("result") != null){  %>
	<%=request.getAttribute("result") %> 
	<%} %>
</body>
</html>