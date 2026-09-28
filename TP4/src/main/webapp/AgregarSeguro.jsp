<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="ServletSeguro?accion=inicio">Inicio</a>
	<a href="ServletSeguro?accion=agregar">Agregar seguros</a>
	<a href="ServletSeguro?accion=listar">Listar seguros</a>

	<h1>
		<strong>Agregar Seguros</strong>
	</h1>

	<form method="get">
		Id Seguro: ${proximoId} <br> 
		Descripción:<input type="text" name="txtDescripcion"><br>
		Tipo de Seguro: <select name="tipoSeguro"></select><br>
		Costo contratación:<input type="text" name="txtCostoContratacion"><br> 
		Costo Máximo Asegurado:<input type="text" name="txtCostoMax"><br> 
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>

</body>
</html>