<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${requestScope.listaTiposSeguros == null or requestScope.listaSeguros == null}">
	<c:redirect url="ServletSeguro?accion=listar" />
</c:if>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Listado de seguros</title>
</head>

<body>

	| <a href="ServletSeguro?accion=inicio">Inicio</a>
	| <a href="ServletSeguro?accion=agregar">Agregar seguros</a>
	| <a href="ServletSeguro?accion=listar">Listar seguros</a> |

	<h1>Listado de seguros</h1>

	<form action = "ServletSeguro" method="get">
	
		<input type="hidden" name="accion" value="listar">
		
		Filtrar por tipo:
		<select id="ddlTipo" name="tipoSeguro">
		
			<option value="0" ${idTipoSeleccionado == 0 ? 'selected' : ''}>
				-- Todos --
			</option>
			
			<c:forEach var="tipo" items="${listaTiposSeguros}">
			
				<option value="${tipo.idTipo}" ${tipo.idTipo == idTipoSeleccionado ? 'selected' : ''}>
					<c:out value="${tipo.descripcion}" />
				</option>
				
			</c:forEach>
		</select>
		
		<input type="submit" name="btnFiltrar" value="Filtrar">
		<input type="submit" name="btnMostrar" value="Mostrar todo">
	
	</form><br>
	
	<table border="1">
		
		<thead>
			<tr>
				<th>ID seguro</th>
                <th>Descripción</th>
                <th>Tipo de seguro</th>
                <th>Costo de contratación</th>
                <th>Costo máximo asegurado</th>
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

</body>
</html>