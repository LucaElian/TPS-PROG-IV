<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>

<body>
	
	<h2>Iniciar sesión</h2>
	
	<form action="ServletUsuario" method="post">
	
		<p>
			<label>Usuario:</label>
			<input type="text" name="txtUsuario" value="${usuarioIng}">
		</p>
		
		<p>
			<label>Contraseña:</label>
			<input type="password" name="txtPassword">
		</p>
		
		<input type="submit" name="btnIngresar" value="Ingresar">
	
		<c:if test="${not empty mensaje}">
			<p>${mensaje}</p>
		</c:if>
	
	</form>
	
</body>
</html>