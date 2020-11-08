<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
</head>
<body>
	
	<form action="/PlanerWebJsp/AddEventServlet" method="get">
		<input type="submit" value="napravi event">
	</form>
	<form action="/PlanerWebJsp/ShowEventsServlet" method="post">
		<input type="date" name="datum" id="datum">
		<input type="submit" value="prikazi eventove">
	</form>
	<table border="1">
	<c:if test="${datum1 != null}">
    Dogadjaji za dan ${datum1}
    <tr>
        <th>Opis</th>
        <th>Pocetak</th>
        <th>Kraj</th>
        <th>Tip</th>
    </tr>
    <c:forEach var = "event" items = "${events}">
    <tr>
        <td>
            <c:out value="${event.description}" />
        </td>
        <td>
            ${event.fromDate.getHours()} : ${event.fromDate.getMinutes()}
        </td>
        <td>
             ${event.toDate.getHours()} : ${event.toDate.getMinutes()}
        </td>
        <td>
            <c:out value="${event.eventType.name}" />
        </td>
    </tr>
    </c:forEach>
    </c:if>
</table>
</body>
</html>