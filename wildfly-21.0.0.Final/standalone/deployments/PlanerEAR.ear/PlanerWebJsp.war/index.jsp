<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/PlanerWebJsp/LoginServlet" method="post">
		<input type="text" name="username" id="username"> <br> 
		<input type="password" name="password" id="password"> <br>
		<input type="submit" value="Pronadji" name="button" /> <br>

	</form>
	Nemas nalog? <a href="register.jsp">register</a>
</body>
</html>