<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado alumnos</h1>

<ul>
	<c:forEach items="${lista}" var="alumno">
		<li> ${alumno.id} - ${alumno.nombre }</li>
	</c:forEach>
</ul>
</body>
</html>