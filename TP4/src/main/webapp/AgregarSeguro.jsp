<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Agregar seguro</title>
</head>

<body>

	| <a href="ServletSeguro?accion=inicio">Inicio</a>
	| <a href="ServletSeguro?accion=agregar">Agregar seguros</a>
	| <a href="ServletSeguro?accion=listar">Listar seguros</a> |

	<h1>Agregar Seguros</h1>

	<form action="ServletSeguro" method="post">
	
		<input type="hidden" name="accion" value="guardar">
	
		Id Seguro: 
		${proximoId} <br><br>
		
		Descripción:
		<input type="text" name="txtDescripcion"> <br><br>
		
		Tipo de Seguro: 
		<select name="tipoSeguro">
		
		</select> <br><br>
		
		Costo contratación:
		<input type="text" name="txtCostoContratacion"> <br><br>
		
		Costo Máximo Asegurado:
		<input type="text" name="txtCostoMax"><br><br>

		<input type="submit" name="btnAceptar" value="Aceptar"> <br>
		
		<c:if test="${not empty mensaje}">
			<p>${mensaje}</p>
		</c:if>

	</form>

</body>
</html>