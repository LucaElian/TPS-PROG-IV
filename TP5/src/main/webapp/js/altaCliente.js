"use strict";

const formularioAlta = document.getElementById("formAltaCliente");
const mensajeValidacion = document.getElementById("mensajeValidacion");


formularioAlta.addEventListener("invalid", function () {
    
	const faltanCampos = Array.from(
		formularioAlta.querySelectorAll("[required]")
    ).some(function (campo) {
            return campo.validity.valueMissing;
    });

	if (faltanCampos)
		mensajeValidacion.textContent = "Debe ingresar todos los campos para poder continuar.";
	else
		mensajeValidacion.textContent = "Revise los datos ingresados. Hay campos con un formato inválido.";
	
	mensajeValidacion.hidden = false;
	
}, true);

formularioAlta.addEventListener("input", function () {
    mensajeValidacion.hidden = true;
});

formularioAlta.addEventListener("reset", function () {
    mensajeValidacion.hidden = true;
});