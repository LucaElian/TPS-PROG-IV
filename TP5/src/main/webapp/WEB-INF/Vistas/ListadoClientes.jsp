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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listado-clientes.css">
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
                <h1 id="clients-title">Tus clientes, <span>en un solo lugar.</span></h1>
                <p class="clients-description">Consult&aacute; y encontr&aacute; la informaci&oacute;n de cada cliente de forma simple.</p>
            </div>
            <a class="app-btn-primary" href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"><i class="bi bi-plus-lg" aria-hidden="true"></i> Nuevo cliente</a>
        </section>
        <section class="clients-summary app-card" aria-label="Resumen de clientes">
            <div class="clients-summary-icon"><i class="bi bi-people" aria-hidden="true"></i></div>
            <div><span class="clients-summary-label">Total de clientes</span><strong>${fn:length(listaClientes)}</strong></div>
            <span class="app-badge app-badge-accent">Registrados</span>
            <div class="clients-summary-decoration" aria-hidden="true"><i class="bi bi-people-fill"></i></div>
        </section>
        <section class="clients-directory app-card" aria-labelledby="directory-title">
            <div class="clients-directory-header">
                <div><h2 id="directory-title">Listado de clientes <span>${fn:length(listaClientes)}</span></h2><p>Busc&aacute; por nombre, DNI, CUIL o cualquier dato del listado.</p></div>
                <span class="clients-directory-icon" aria-hidden="true"><i class="bi bi-list-ul"></i></span>
            </div>
            <div class="clients-table-area">
                <table id="tablaClientes" class="app-table" aria-label="Clientes registrados">
                    <thead><tr>
                        <th scope="col">DNI</th><th scope="col">CUIL</th><th scope="col">Nombre y apellido</th>
                        <th scope="col">Sexo</th><th scope="col">Fecha de nacimiento</th><th scope="col">Direcci&oacute;n</th>
                        <th scope="col">Nacionalidad</th><th scope="col">Localidad</th><th scope="col">Provincia</th>
                    </tr></thead>
                    <tbody>
                        <c:forEach var="cliente" items="${listaClientes}">
                            <tr>
                                <td><span class="clients-dni"><c:out value="${cliente.dni}" /></span></td>
                                <td class="clients-cuil"><c:out value="${cliente.cuil}" /></td>
                                <td><div class="clients-person"><span class="clients-avatar" aria-hidden="true"><c:out value="${fn:substring(cliente.nombre, 0, 1)}${fn:substring(cliente.apellido, 0, 1)}" /></span><span><c:out value="${cliente.nombre} ${cliente.apellido}" /></span></div></td>
                                <td><span class="clients-sex"><c:out value="${cliente.sexo}" /></span></td>
                                <td><c:out value="${cliente.fecha}" /></td><td><c:out value="${cliente.direccion}" /></td>
                                <td><c:out value="${cliente.nacionalidad}" /></td><td><c:out value="${cliente.localidad}" /></td><td><c:out value="${cliente.provincia}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <footer class="clients-footer">Gesti&oacute;n de clientes <span>Organiz&aacute;. Consult&aacute;. Conect&aacute;.</span></footer>
    </main>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/listadoClientes.js"></script>
</body>
</html>