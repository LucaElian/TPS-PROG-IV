<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <p>Usuario: <c:out value="${sessionScope.usuario}" /></p>
    <p>Todos los campos son obligatorios.</p>
    <c:if test="${not empty mensaje}">
        <p role="status"><c:out value="${mensaje}" /></p>
    </c:if>
    <p id="mensajeValidacion" role="alert" hidden="hidden"></p>
    <form id="formAltaCliente" action="${pageContext.request.contextPath}/ServletCliente" method="post" accept-charset="UTF-8">
        <input type="hidden" name="accion" value="agregar">
        <p>
            <label for="txtDni">DNI:</label>
            <input type="text" id="txtDni" name="txtDni" inputmode="numeric" pattern="[0-9]{6,8}"  maxlength="8" title="Ingrese entre 6 y 8 dígitos, sin puntos." required>
        </p>
        <p>
            <label for="txtCuil">CUIL:</label>
            <input type="text" id="txtCuil" name="txtCuil" inputmode="numeric" pattern="[0-9]{11}" maxlength="11" title="Ingrese 11 dígitos, sin guiones." required>
        </p>
        <p>
            <label for="txtNombre">Nombre:</label>
            <input type="text" id="txtNombre" name="txtNombre" pattern="[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+( [A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+)*" maxlength="100" title="Ingrese solo letras y espacios entre palabras." required>
        </p>
        <p>
            <label for="txtApellido">Apellido:</label>
            <input type="text" id="txtApellido" name="txtApellido" pattern="[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+( [A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+)*" maxlength="100" title="Ingrese solo letras y espacios entre palabras." required>
        </p>
        <p>
            <label for="ddlSexo">Sexo:</label>
            <select id="ddlSexo" name="ddlSexo" required>
                <option value="">Seleccione una opción</option>
                <option value="M">M</option>
                <option value="F">F</option>
                <option value="Otro">Otro</option>
            </select>
        </p>
        <p>
            <label for="txtFecha">Fecha de nacimiento:</label>
            <input type="date" id="txtFecha" name="txtFecha" required>
        </p>
        <p>
            <label for="txtDireccion">Dirección:</label>
            <input type="text" id="txtDireccion" name="txtDireccion" pattern=".*\S.*" maxlength="150" title="Ingrese una dirección con letras y/o números." required>
        </p>
        <p>
            <label for="txtNacionalidad">Nacionalidad:</label>
            <input type="text" id="txtNacionalidad" name="txtNacionalidad" pattern="[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+( [A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+)*" maxlength="50" title="Ingrese solo letras y espacios entre palabras." required>
        </p>
        <p>
            <label for="txtLocalidad">Localidad:</label>
            <input type="text" id="txtLocalidad" name="txtLocalidad" pattern="[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+( [A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+)*" maxlength="50" title="Ingrese solo letras y espacios entre palabras." required>
        </p>
        <p>
            <label for="txtProvincia">Provincia:</label>
            <input type="text" id="txtProvincia" name="txtProvincia" pattern="[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+( [A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+)*" maxlength="50" title="Ingrese solo letras y espacios entre palabras." required>
        </p>
        <p>
            <label for="txtCorreo">Correo electrónico:</label>
            <input type="email" id="txtCorreo" name="txtCorreo" maxlength="100" required>
        </p>
        <p>
            <label for="txtTelefono">Teléfono:</label>
            <input type="tel" id="txtTelefono" name="txtTelefono" inputmode="numeric" pattern="[0-9]{10}"  maxlength="10" title="Ingrese 10 dígitos, sin espacios ni guiones." required>
        </p>
        <button type="submit" name="btnAgregar" value="Agregar">Guardar cliente</button>
        <button type="reset">Limpiar</button>
    </form>
    <script src="${pageContext.request.contextPath}/js/altaCliente.js"></script>
</body>
</html>