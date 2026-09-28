<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Seguros</title>
</head>
<a href= "Inicio.jsp"> "Inicio"</a>
<a href= "AgregarSeguros.jsp"> "Agregar seguros"</a>
<a href= "ListadoSeguros.jsp"> "Listado de Seguros"</a>
<br>
<form action = "servletSeguro" method= "POST">
<h1> Listado de Seguros</h1>
<label for= "ddlTipo"> Filtrar por Tipo:</label>
			<select id="ddlTipo" name="ddlTipo">
				<option value ="0"> -- Selecciona una opcion -- </option>
					<c:forEach var= "tipo" items="${ seguros }">
			
						<option value ="${tipo.idTipo }"> ${ tipo.descripcion} </option>
					</c:forEach>
			</select>
<input type = "submit" name="btnFiltrar" value ="Filtrar">
<input type = "submit" name="btnMostrar" value ="Mostrar Todo">
<br>
<br>
<table border= "1">
	<thead>
		<tr>
			<th>ID Seguro</th>
			<th> Descripcion </th>
			<th> Tipo de Seguro</th>
			<th> Costo de Contratacion</th>
			<th> Costo Max Asegurado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="seg" items="${listaSeguros}">
                    <tr>
                        <td>${seg.idSeguro}</td>
                        <td>${seg.descripcion}</td>
                        <td>${seg.tipoSeguro.descripcion}</td>
                        <td>${seg.costoContratacion}</td>
                        <td>${seg.costoAsegurado}</td>
                    </tr>
       </c:forEach>
	</tbody>
</table>

</form>
<body>

</body>
</html>