<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	 <link rel="stylesheet" href="css/formularios.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script>
	 $(document).ready(function(){
	 $("#formulario").keyup(function() { //Cada vez que se levante la tecla del formulario
		var kaka = true;
		if($('#id').val() && $('#nombre').val()){ //comprueba que estos campos no estén vacíos
		   $.ajax({
			  type: "POST",
		      url: 'http://localhost:8080/colegio/tasa',
		      data: {
		         format: $("#nombre").val()
		      },
		      success: function(data) {
		         $('#tasa').val(data)
		      }
		   });
	 }
		});
	 });
	 </script>
</head>
<body>
<header>
<h2>Inserción de nueva matrícula</h2>
</header>


<%@include file="/menu.html" %>

<div class="container">
	<div class="form" id="formulario"> 
		<form action="http://localhost:8080/colegio/insertarmatriculaciones" method="post" id="formulario">
		 
		  <label for="id">DNI Alumno</label>
		  <input type="text" id="id" name="id">
		  <label for="nombre">Nombre Alumno</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  
		  <select name="municipios" id="municipios" form="formulario">
		  		<c:forEach items="${comboMunicipios}" var="municipio">
		  		
		  			<option value="${municipio.id}"> ${municipio.descripcion}</option>
		  		
		  		
		  		</c:forEach>
		  
		  </select>
		  
		  		  <input type="text" id="tasa" name="tasa"><br>
		  
		  <input type="submit" value="Enviar">
		</form> 
		

	</div>
	
		<c:if test="${resultado == 1}" >
   			<b>Alumno insertado correctamente</b>
		</c:if>
</div>

<div id="respuesta"></div>



</body>
</html>