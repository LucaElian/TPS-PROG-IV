
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

    <div id="contenedor-principal">

        <nav id="menu-lateral">
            <h3>Menú</h3>
            <ul>
                <li><a href="altaCliente.jsp">Alta de Cliente</a></li>
                <li><a href="ServletCliente?accion=listar">Listado de Clientes</a></li>
            </ul>
        </nav>

        <main id="contenido-central">

            <header>
                <h2>Formulario de Cliente</h2>
                <p>
                    <strong>Usuario:</strong>
                    <c:choose>
                        <c:when test="${not empty sessionScope.usuario}">
                            ${sessionScope.usuario.nombre != null ? sessionScope.usuario.nombre : sessionScope.usuario}
                        </c:when>
                        <c: otherwise>
                            <span>Invitado / No logueado</span>
                        </c:>
                    </c:choose>
                </p>
            </header>

            <section>
                <h3>Listado de Clientes (${not empty listaClientes ? fn:length(listaClientes) : 0})</h3>

                <table id="tablaClientes" class="display" style="width:100%">
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
                        <c:choose>
                            <c:when test="${not empty listaClientes}">
                                <c:forEach var="cli" items="${listaClientes}">
                                    <tr>
                                        <td>${cli.dni}</td>
                                        <td>${cli.cuil}</td>
                                        <td>${cli.nombre} ${cli.apellido}</td>
                                        <td>${cli.sexo}</td>
                                        <td>${cli.fechaNacimiento}</td>
                                        <td>${cli.direccion}</td>
                                        <td>${cli.nacionalidad}</td>
                                        <td>${cli.localidad}</td>
                                        <td>${cli.provincia}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <!-- no hat datos -->
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </section>
        </main>
    </div>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/listadoClientes.js"">
    </script>
</body>
</html>
