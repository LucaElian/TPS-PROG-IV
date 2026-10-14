<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Clientes</title>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
</head>

<body>

	<h3>Menú</h3>

	<a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar">Alta de Cliente</a>
	|
	<a href="${pageContext.request.contextPath}/ServletCliente?accion=listar">Listado de Clientes</a>
	
	<hr>
	
	<h1>Listado de Clientes</h1>
	
	<p>Usuario: ${sessionScope.usuario}</p>
	
	<h3>Cantidad de clientes (${fn:length(listaClientes)})</h3>

	<table id="tablaClientes">
	
		<thead>
        	<tr>
	            <th>DNI</th>
	            <th>CUIL</th>
	            <th>Nombre y Apellido</th>
	            <th>Sexo</th>
	            <th>Fecha de Nacimiento</th>
	            <th>Dirección</th>
	            <th>Nacionalidad</th>
	            <th>Localidad</th>
	            <th>Provincia</th>
            </tr>
		</thead>
        
        <tbody>
        	<c:forEach var="cliente" items="${listaClientes}">
            	<tr>
	                <td>${cliente.dni}</td>
	                <td>${cliente.cuil}</td>
	                <td>${cliente.nombre} ${cliente.apellido}</td>
	                <td>${cliente.sexo}</td>
	                <td>${cliente.fecha}</td>
	                <td>${cliente.direccion}</td>
	                <td>${cliente.nacionalidad}</td>
	                <td>${cliente.localidad}</td>
	                <td>${cliente.provincia}</td>
                </tr>
           	</c:forEach>
            
  		</tbody>
                
   	</table>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/listadoClientes.js"></script>
    
</body>
</html>
