<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    	  rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
          crossorigin="anonymous">

    <link rel="stylesheet" 
    	  href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" 
    	  href="${pageContext.request.contextPath}/css/app-theme.css">
</head>

<body>

    <main class="login-viewport">
    
        <div class="ambient-mesh" aria-hidden="true">
            <div class="glow-orb glow-orb-1"></div>
            <div class="glow-orb glow-orb-2"></div>
            <div class="technical-grid"></div>
        </div>

        <div class="login-card-single app-card">
            <div class="app-card-body p-4 p-sm-5">

                <div class="text-center mb-4">
                    <div class="login-icon-badge mb-3">
                        <i class="bi bi-person-fill-lock"></i>
                    </div>
                    
                    <h2 class="login-title">Iniciar sesión</h2>
                </div>

                <form action="${pageContext.request.contextPath}/ServletUsuario" method="post">

                    <div class="app-form-group mb-3">
                        <label for="txtUsuario" class="app-label">Usuario:</label>
                        
                        <div class="app-input-wrapper">
                            <i class="bi bi-person-fill app-input-icon"></i>
                            
                            <input
                                type="text"
                                id="txtUsuario"
                                name="txtUsuario"
                                class="app-input"
                                value="${usuarioIng}"
                                autocomplete="username"
                                autofocus>
                        </div>
                    </div>

                    <div class="app-form-group mb-4">
                        <label for="txtPassword" class="app-label">Contraseña:</label>
                        
                        <div class="app-input-wrapper password-wrapper">
                            <i class="bi bi-key-fill app-input-icon"></i>
                            
                            <input type="password"
                                   id="txtPassword"
                                   name="txtPassword"
                                   class="app-input password-input"
                                   autocomplete="current-password">
                            
                            <button type="button"
								    id="btnMostrarPassword"
								    class="app-password-toggle"
								    aria-label="Mostrar contraseña">
								<i id="iconoPassword" class="bi bi-eye"></i>
							</button>
                        </div>
                    </div>

					<c:if test="${not empty mensaje}">
	                    <div class="app-alert app-alert-danger" role="alert">
	                        <i class="bi bi-exclamation-triangle-fill alert-icon"></i>
                           	<span>${mensaje}</span>
	                    </div>
                	</c:if>

                    <div class="d-grid mt-4">
                        <input type="submit"
                            value="Ingresar"
                            class="app-btn-primary w-100 py-3">
                    </div>

                </form>

            </div>
        </div>

    </main>

	<script src="${pageContext.request.contextPath}/js/login.js"></script>

</body>
</html>
