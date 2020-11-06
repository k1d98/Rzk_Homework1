<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="/PlanerWebJsp/RegisterServlet" method="post">
		username:<input type="text" name="username" id="username"> <br> 
		ime:<input type="text" name="firstname" id="firstname"> <br> 
		prezime:<input type="text" name="lastname" id="lastname"> <br> 
		sifra:<input type="password" name="password" id="password"> <br>
		<input type="submit" value="Napravi profil" name="button" /> <br>
	</form>
</body>
</html>