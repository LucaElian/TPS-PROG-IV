<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

	<meta charset="UTF-8">
	<title>Login</title>

</head>
<body>
	
	<h2>Iniciar sesión</h2>
	
	<form action="<%= request.getContextPath() %>/ServletLogin" method="post">
	
		<label>Usuario:</label>
		<input type="text" name="txtUsuario">
		
		<br><br>
		
		<label>Contraseña:</label>
		<input type="password" name="txtPassword">
		
		<br><br>
		
		<input type="submit" value="Ingresar">
	
	</form>
	
	<p>${mensaje}</p>
	
</body>
</html>