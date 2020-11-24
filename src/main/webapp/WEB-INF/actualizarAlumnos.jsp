<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/formularios.css">
  <link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado alumnos</h1>
<%@include file="/menu.html" %>


<div class="container">

<h2> Actualizar Alumnos</h2>
	<div class="form"> 
		<form action="http://localhost:8080/colegio/formularioactualizaralumnos" method="post">
		  
		  <label for="id">Id Alumno</label>
		  <input type="text" id="id" name="id">
		  <label for="nombre">Nombre Alumno</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	

<c:forEach items="${lista}" var="alumno">

	<div class="form">
		<form action="http://localhost:8080/colegio/actualizaralumno" method="post">
			<input class="hidden" type="text" id="idOld" name="idOld" value="${alumno.id}">
			<label for="id"> Id Alumno </label>
			<input type="text" id="id" name="id" value="${alumno.id}">
			<label for="nombre"> Nombre Alumno </label>
			<input type="text" id="nombre" name="nombre" value="${alumno.nombre}"> </br>
			
			<label for="municipios"> Municipio </label>
			<select name="municipios" id="municipios" >
				<c:forEach items="${comboMunicipios}" var="municipio">
				
					<option value="${municipio.id }"> ${municipio.descripcion }</option>
				
				</c:forEach>
				<option value="${alumno.idMunicipio }" selected> ${alumno.municipio }</option>
			
			</select>
		<input type="submit" value="Modificar">
		</form>
	
	</div>


</c:forEach>
</div>

</body>
</html>