<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alta de Cliente</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/general.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/alta.css">
</head>

<body>

    <main class="alta-viewport">

        <div class="ambient-mesh" aria-hidden="true">
            <div class="glow-orb glow-orb-1"></div>
            <div class="glow-orb glow-orb-2"></div>
            <div class="technical-grid"></div>
        </div>

        <aside class="alta-sidebar">
            <h3 class="alta-menu-title">Menú</h3>

            <nav class="alta-menu">
                <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"
                   class="alta-menu-link active">
                    <i class="bi bi-person-plus-fill"></i>
                    Alta de Cliente
                </a>

                <a href="${pageContext.request.contextPath}/ServletCliente?accion=listar"
                   class="alta-menu-link">
                    <i class="bi bi-list-ul"></i>
                    Listado de Clientes
                </a>
            </nav>
        </aside>

        <section class="alta-content">

            <div class="alta-heading mb-4">
                <h1>Formulario de Cliente</h1>

                <p class="alta-user">
                    <i class="bi bi-person-circle"></i>
                    Usuario: <strong>${sessionScope.usuario}</strong>
                </p>
            </div>
            
			<c:if test="${not empty errores}">
                <div class="app-alert app-alert-danger mt-4" role="alert">
                    <i class="bi bi-exclamation-triangle-fill alert-icon"></i>

                    <div>
                        <p class="mb-2"><strong>No se pudo guardar el cliente. Revise los siguientes datos:</strong></p>

                        <ul class="mb-0">
                            <c:forEach var="error" items="${errores}">
                            	<li><strong> <c:out value="${error}" /></strong></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty mensaje}">
                <div class="app-alert app-alert-success mt-4" role="status">
                    <i class="bi bi-check-circle-fill"></i>
                    <span><strong><c:out value="${mensaje}" /></strong></span>
                </div>
            </c:if>
            
            <div class="app-card alta-form-card">
                <div class="app-card-body">

                    <form action="${pageContext.request.contextPath}/ServletCliente"
                          method="post"
                          novalidate>

                        <input type="hidden" name="accion" value="guardar">

                        <div class="row g-3">

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtDni" class="app-label">DNI *</label>

                                    <input type="text"
                                           id="txtDni"
                                           name="txtDni"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.dni}' />"
                                           inputmode="numeric"
                                           maxlength="8">

                                    <small class="alta-help">
                                        Ingrese entre 6 y 8 dígitos, sin puntos
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtCuil" class="app-label">CUIL *</label>

                                    <input type="text"
                                           id="txtCuil"
                                           name="txtCuil"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.cuil}' />"
                                           inputmode="numeric"
                                           maxlength="11">

                                    <small class="alta-help">
                                        Ingrese 11 dígitos, sin guiones
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtNombre" class="app-label">Nombre *</label>

                                    <input type="text"
                                           id="txtNombre"
                                           name="txtNombre"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.nombre}' />"
                                           maxlength="100">

                                    <small class="alta-help">
                                        Ingrese solo letras y espacios entre palabras
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtApellido" class="app-label">Apellido *</label>

                                    <input type="text"
                                           id="txtApellido"
                                           name="txtApellido"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.apellido}' />"
                                           maxlength="100">

                                    <small class="alta-help">
                                        Ingrese solo letras y espacios entre palabras
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="ddlSexo" class="app-label">Sexo *</label>

                                    <select id="ddlSexo"
                                            name="ddlSexo"
                                            class="app-input no-icon alta-select">

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
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtNacionalidad" class="app-label">Nacionalidad *</label>

                                    <input type="text"
                                           id="txtNacionalidad"
                                           name="txtNacionalidad"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.nacionalidad}' />"
                                           maxlength="50">

                                    <small class="alta-help">
                                        Ingrese solo letras y espacios entre palabras
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtFecha" class="app-label">Fecha de nacimiento *</label>

                                    <input type="date"
                                           id="txtFecha"
                                           name="txtFecha"
                                           class="app-input no-icon alta-date"
                                           value="<c:out value='${clienteIng.fecha}' />"
                                           max="<%= LocalDate.now() %>">
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtDireccion" class="app-label">Dirección *</label>

                                    <input type="text"
                                           id="txtDireccion"
                                           name="txtDireccion"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.direccion}' />"
                                           maxlength="150">

                                    <small class="alta-help">
                                        Ingrese una dirección con letras y/o números
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtLocalidad" class="app-label">Localidad *</label>

                                    <input type="text"
                                           id="txtLocalidad"
                                           name="txtLocalidad"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.localidad}' />"
                                           maxlength="50">

                                    <small class="alta-help">
                                        Ingrese solo letras y espacios entre palabras
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtProvincia" class="app-label">Provincia *</label>

                                    <input type="text"
                                           id="txtProvincia"
                                           name="txtProvincia"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.provincia}' />"
                                           maxlength="50">

                                    <small class="alta-help">
                                        Ingrese solo letras y espacios entre palabras
                                    </small>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtCorreo" class="app-label">Correo electrónico *</label>

                                    <input type="email"
                                           id="txtCorreo"
                                           name="txtCorreo"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.correo}' />"
                                           maxlength="100">
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="app-form-group mb-0">
                                    <label for="txtTelefono" class="app-label">Teléfono *</label>

                                    <input type="text"
                                           id="txtTelefono"
                                           name="txtTelefono"
                                           class="app-input no-icon"
                                           value="<c:out value='${clienteIng.telefono}' />"
                                           inputmode="numeric"
                                           maxlength="10">

                                    <small class="alta-help">
                                        Ingrese 10 dígitos, sin espacios ni guiones
                                    </small>
                                </div>
                            </div>

                        </div>

                        <div class="alta-actions mt-4">
                            <button type="submit" class="app-btn-primary">
                                <i class="bi bi-check-lg"></i>
                                Guardar cliente
                            </button>

                            <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar"
                               class="app-btn-secondary">
                                Limpiar
                            </a>
                        </div>

                    </form>

                </div>
            </div>

        </section>

    </main>

</body>
</html>