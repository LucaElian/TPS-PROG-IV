"use strict";

const txtPassword = document.getElementById("txtPassword");
const btnMostrarPassword = document.getElementById("btnMostrarPassword");
const iconoPassword = document.getElementById("iconoPassword");

btnMostrarPassword.addEventListener("click", function () {

	if (txtPassword.type === "password") {

		txtPassword.type = "text";

		iconoPassword.classList.remove("bi-eye");
		iconoPassword.classList.add("bi-eye-slash");

		btnMostrarPassword.setAttribute(
			"aria-label",
			"Ocultar contraseña"
		);

	} else {

		txtPassword.type = "password";

		iconoPassword.classList.remove("bi-eye-slash");
		iconoPassword.classList.add("bi-eye");

		btnMostrarPassword.setAttribute(
			"aria-label",
			"Mostrar contraseña"
		);
	}

});