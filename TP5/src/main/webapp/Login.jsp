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
	
	<form action="${pageContext.request.contextPath}/ServletUsuario" method="post">
	
		<p>
			<label for="txtUsuario">Usuario:</label>
			<input type="text" id="txtUsuario" name="txtUsuario" value="${usuarioIng}">
		</p>
		
		<p>
			<label for="txtPassword">Contraseña:</label>
			<input type="password" id="txtPassword" name="txtPassword">
		</p>
		
		<input type="submit" name="btnIngresar" value="Ingresar">
	
		<c:if test="${not empty mensaje}">
			<p>${mensaje}</p>
		</c:if>
	
	</form>
	
</body>
</html>