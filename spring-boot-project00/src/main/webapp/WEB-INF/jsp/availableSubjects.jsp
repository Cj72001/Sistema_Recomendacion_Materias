<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="/WEB-INF/jsp/include-css.jsp"%>
<title>Available Subjects</title>

<style>
	.btn2 {
		margin-bottom: 20px; /* Añade un margen inferior al botón */
		color: white; /* Color del texto */
		border: none; /* Sin borde */
		padding: 10px 20px; /* Espaciado interno */
		cursor: pointer; /* Cambia el cursor al pasar por el botón */
		font-size: 16px; /* Tamaño de fuente */
		transition: background-color 0.3s, color 0.3s, border 0.3s; /* Transición suave para el cambio de color y borde */
	}
	.btn2:hover {
		background-color: #f2f2f2; /* Color de fondo al pasar el mouse */
		color: black; /* Color del texto al pasar el mouse */
		border: 1px solid #333; /* Borde gris-negro al pasar el mouse */
	}
	.links div {
		margin-top: 10px; /* Añade un margen superior a los enlaces */
	}
</style>

</head>

<body>
	<!-- inluyendo header -->
	<%@include file="/WEB-INF/jsp/header.jsp"%>

	<div>

		<div>
			<h4 class="colordiv">Estas son las materias que puedes inscribir
			</h4>
			<img src="<c:url value='/resources/img/subjects.jpg'/>" width="25px" />
		</div>

		<h1 class="colordiv">${errorSem3}</h1>

		<div>
			<table class="tablaNormal" border="1px">

				<tr>
					<td bgcolor="#e5e5e5">Numero Correlativo</td>
					<td bgcolor="#e5e5e5">Nombre de la materia</td>
					<td bgcolor="#e5e5e5">UV's</td>
					<td bgcolor="#e5e5e5">Prerequisito</td>
				</tr>

				<c:forEach var="m" items="${materias}">

					<tr>
						<td>${m.getIdMateria()}</td>
						<td>${m.getNombreMateria()}</td>
						<td>${m.getUv()}</td>
						<td>${m.getPreRequisito()}</td>
					</tr>

				</c:forEach>

			</table>
		</div>

		<!-- tabla para las materias recomendadas: -->
		<div>
			<h4 class="colordiv">Te recomendamos las siguientes materias</h4>
		</div>

		<!-- error cuando la lista de materiasR esta vacia -->
		<h1 class="colordiv">${errorSem4}</h1>

		<div>
			<table class="tablaNormal" border="1px">

				<tr>
					<td bgcolor="#e5e5e5">Numero Correlativo</td>
					<td bgcolor="#e5e5e5">Nombre de la materia</td>
					<td bgcolor="#e5e5e5">UV's</td>
					<td bgcolor="#e5e5e5">Prerequisito</td>
				</tr>
				
				<!-- la lista que se pasara contendra las materias recomendadas -->
				<c:forEach var="m" items="${materiasR}"> 

					<tr>
						<td>${m.getIdMateria()}</td>
						<td>${m.getNombreMateria()}</td>
						<td>${m.getUv()}</td>
						<td>${m.getPreRequisito()}</td>
					</tr>

				</c:forEach>

			</table>
		</div>
		<!-- termina tabla materias recomendadas-->


		<form method="post" action="subjectsUpdateSuccess" enctype="multipart/form-data">
			<div class="box">

				<h3>${errorSU}</h3>
				<label for="file">Seleccionar Excel:</label>
				<input type="file" name="file" id="file" required>
				<br> <input class="btn2" type="submit" value="Agregar">
			</div>
			<!-- End Box -->

		</form>

	</div>




</body>

</html>