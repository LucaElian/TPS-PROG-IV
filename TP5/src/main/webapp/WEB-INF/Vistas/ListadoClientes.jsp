<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Clientes</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet"
          href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/general.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/listar.css">
</head>

<body>

    <main class="listado-viewport">

        <div class="ambient-mesh" aria-hidden="true">
            <div class="glow-orb glow-orb-1"></div>
            <div class="glow-orb glow-orb-2"></div>
            <div class="technical-grid"></div>
        </div>

        <aside class="listado-sidebar">
            <h3 class="listado-menu-title">Menú</h3>

            <nav class="listado-menu">
                <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"
                   class="listado-menu-link">
                    <i class="bi bi-person-plus-fill"></i>
                    Alta de Cliente
                </a>

                <a href="${pageContext.request.contextPath}/ServletCliente?accion=listar"
                   class="listado-menu-link active">
                    <i class="bi bi-list-ul"></i>
                    Listado de Clientes
                </a>
            </nav>
        </aside>

        <section class="listado-content">

            <div class="listado-heading mb-4">
                <h1>Listado de Clientes</h1>

                <p class="listado-user">
                    <i class="bi bi-person-circle"></i>
                    Usuario: <strong>${sessionScope.usuario}</strong>
                </p>
            </div>

            <div class="app-card listado-card">

                <div class="listado-card-header">
                    <div>
                        <h2>Clientes registrados</h2>

                        <p>
                            Cantidad de clientes:
                            <strong>${fn:length(listaClientes)}</strong>
                        </p>
                    </div>

                    <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"
                       class="app-btn-primary">
                        <i class="bi bi-person-plus"></i>
                        Nuevo cliente
                    </a>
                </div>

                <div class="listado-table-wrapper">

                    <table id="tablaClientes" class="app-table">

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

                </div>

            </div>

        </section>

    </main>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/listadoClientes.js"></script>

</body>

</html>