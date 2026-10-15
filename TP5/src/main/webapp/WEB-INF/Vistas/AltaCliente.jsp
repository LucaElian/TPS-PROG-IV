<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alta de Cliente</title>
</head>

<body>

    <h3>Menú</h3>
    
    <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar">Alta de Cliente</a>
    <a href="${pageContext.request.contextPath}/ServletCliente?accion=listar">Listado de Clientes</a>
    
    <hr>
    
    <h1>Alta de Cliente</h1>
    
    <p>Usuario: ${sessionScope.usuario}</p>
    
    <c:if test="${not empty errores}">
        <div role="alert">
            <p>No se pudo guardar el cliente. Revise los siguientes datos:</p>
            <ul>
                <c:forEach var="error" items="${errores}">
                    <li><c:out value="${error}" /></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form id="formAltaCliente" action="${pageContext.request.contextPath}/ServletCliente" method="post">
    
        <input type="hidden" name="accion" value="guardar">
        
        <p>
            <label for="txtDni">DNI *</label> <br>
            <input type="text" id="txtDni" name="txtDni" value="<c:out value='${clienteIng.dni}' />" inputmode="numeric" pattern="[0-9]{6,8}"  maxlength="8" required> <br>
            <small>Ingrese entre 6 y 8 dígitos, sin puntos</small>
        </p>
        
        <p>
            <label for="txtCuil">CUIL *</label> <br>
            <input type="text" id="txtCuil" name="txtCuil" value="<c:out value='${clienteIng.cuil}' />" inputmode="numeric" pattern="[0-9]{11}" maxlength="11" required> <br>
            <small>Ingrese 11 dígitos, sin guiones</small>
        </p>
        
        <p>
            <label for="txtNombre">Nombre *</label> <br>
            <input type="text" id="txtNombre" name="txtNombre" value="<c:out value='${clienteIng.nombre}' />" pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]+" maxlength="100" required> <br>
            <small>Ingrese solo letras y espacios entre palabras</small>
        </p>
        
        <p>
            <label for="txtApellido">Apellido *</label> <br>
            <input type="text" id="txtApellido" name="txtApellido" value="<c:out value='${clienteIng.apellido}' />" pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]+" maxlength="100" required> <br>
            <small>Ingrese solo letras y espacios entre palabras</small>
        </p>
        
        <p>
            <label for="ddlSexo">Sexo *</label> <br>
            
            <select id="ddlSexo" name="ddlSexo" required>
            
                <option value="">-- Seleccione una opción --</option>
                
                <option value="M"
					${clienteIng.sexo == 'M' ? 'selected' : ''}>
					M
				</option>
				
                <option value="F"
					${clienteIng.sexo == 'F' ? 'selected' : ''}>
					F
				</option>
				
                <option value="Otro"
					${clienteIng.sexo == 'Otro' ? 'selected' : ''}>
					Otro
				</option>
				
            </select>
        </p>
        
        <p>
            <label for="txtFecha">Fecha de nacimiento *</label> <br>
            <input type="date" id="txtFecha" name="txtFecha" value="<c:out value='${clienteIng.fecha}' />" max="<%= LocalDate.now() %>" required>
        </p>
        
        <p>
            <label for="txtDireccion">Dirección *</label> <br>
            <input type="text" id="txtDireccion" name="txtDireccion" value="<c:out value='${clienteIng.direccion}' />" maxlength="150" required> <br>
            <small>Ingrese una dirección con letras y/o números</small>
        </p>
        
        <p>
            <label for="txtNacionalidad">Nacionalidad *</label> <br>
            <input type="text" id="txtNacionalidad" name="txtNacionalidad" value="<c:out value='${clienteIng.nacionalidad}' />" pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]+" maxlength="50" required> <br>
            <small>Ingrese solo letras y espacios entre palabras</small>
        </p>
        
        <p>
            <label for="txtLocalidad">Localidad *</label> <br>
            <input type="text" id="txtLocalidad" name="txtLocalidad" value="<c:out value='${clienteIng.localidad}' />" pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]+" maxlength="50" required> <br>
            <small>Ingrese solo letras y espacios entre palabras</small>
        </p>
        
        <p>
            <label for="txtProvincia">Provincia *</label> <br>
            <input type="text" id="txtProvincia" name="txtProvincia" value="<c:out value='${clienteIng.provincia}' />" pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]+" maxlength="50" required> <br>
            <small>Ingrese solo letras y espacios entre palabras</small>
        </p>
       
        <p>
            <label for="txtCorreo">Correo electrónico *</label> <br>
            <input type="email" id="txtCorreo" name="txtCorreo" value="<c:out value='${clienteIng.correo}' />" maxlength="100" required> <br>
        </p>
        
        <p>
            <label for="txtTelefono">Teléfono *</label> <br>
            <input type="text" id="txtTelefono" name="txtTelefono" value="<c:out value='${clienteIng.telefono}' />" inputmode="numeric" pattern="[0-9]{10}" maxlength="10" required> <br>
        	<small>Ingrese 10 dígitos, sin espacios ni guiones</small>
        </p>

        <input type="submit" name="btnGuardar" value="Guardar cliente">
        <input type="reset" value="Limpiar">

	</form>
	
    <p id="mensajeValidacion" hidden="hidden"></p>
    
	<c:if test="${not empty mensaje}">
    	<p role="status"><c:out value="${mensaje}" /></p>
  	</c:if>
        
    
    <script src="${pageContext.request.contextPath}/js/altaCliente.js"></script>

</body>
</html>