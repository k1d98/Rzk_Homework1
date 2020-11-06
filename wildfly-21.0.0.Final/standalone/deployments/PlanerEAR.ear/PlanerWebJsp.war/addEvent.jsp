<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Dodaj event</title>
</head>
<body>
	<form action="/PlanerWebJsp/AddEventServlet" method="post">
		Opis: <input type="text" name="description" id="description"> <br>
		Vreme: <br>
		<input type="date" id="datum" name="datum"><br>
		od: <input type="time" id="fromDate" name="fromDate"><br>
		do: <input type="time" id="toDate" name="toDate"> <br>
		Tip eventa: 
			<select name = "eventType">
				<c:forEach var = "eventType" items = "${eventTypes}">
					<option value = "${eventType.id }">${eventType.name}</option>
				</c:forEach>
			</select>
			<br>
		<input type="submit" value="Sacuvaj">
	</form>
</body>
</html>