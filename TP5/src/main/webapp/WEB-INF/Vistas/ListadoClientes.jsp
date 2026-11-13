<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Clientes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css?v=2">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listar.css?v=2">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listado-clientes.css?v=2">
</head>
<body class="clients-page">
    <div class="ambient-mesh" aria-hidden="true">
        <div class="glow-orb glow-orb-1"></div>
        <div class="glow-orb glow-orb-2"></div>
        <div class="technical-grid"></div>
    </div>
    <header class="clients-topbar">
        <a class="clients-brand" href="${pageContext.request.contextPath}/ServletCliente?accion=listar">
            <span class="clients-brand-icon"><i class="bi bi-people-fill" aria-hidden="true"></i></span>
            <span>Gesti&oacute;n de clientes</span>
        </a>
        <nav class="clients-nav" aria-label="Menú principal">
            <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"><i class="bi bi-person-plus" aria-hidden="true"></i> Alta de cliente</a>
            <a class="is-active" aria-current="page" href="${pageContext.request.contextPath}/ServletCliente?accion=listar"><i class="bi bi-grid" aria-hidden="true"></i> Listado de clientes</a>
        </nav>
        <div class="clients-user"><i class="bi bi-person-circle" aria-hidden="true"></i><span><small>Usuario</small><c:out value="${sessionScope.usuario}" /></span></div>
    </header>
    <main class="clients-main">
        <div class="clients-breadcrumb">Clientes <span aria-hidden="true">/</span> <span>Listado</span></div>
        <section class="clients-heading" aria-labelledby="clients-title">
            <div>
                <p class="clients-eyebrow"><span></span> DIRECTORIO DE CLIENTES</p>
                <h1 id="clients-title">TUS CLIENTES</h1>
                <p class="clients-description">Consult&aacute; y encontr&aacute; la informaci&oacute;n de cada cliente de forma simple.</p>
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
