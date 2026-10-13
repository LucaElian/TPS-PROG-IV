"use strict";

const formularioAlta = document.getElementById("formAltaCliente");
const fechaNacimiento = document.getElementById("txtFecha");
const mensajeValidacion = document.getElementById("mensajeValidacion");

function actualizarFechaMaxima() {
    const hoy = new Date();
    const mes = String(hoy.getMonth() + 1).padStart(2, "0");
    const dia = String(hoy.getDate()).padStart(2, "0");
    fechaNacimiento.max = `${hoy.getFullYear()}-${mes}-${dia}`;
}

actualizarFechaMaxima();
fechaNacimiento.addEventListener("focus", actualizarFechaMaxima);

formularioAlta.addEventListener("invalid", function () {
    const faltanCampos = Array.from(formularioAlta.querySelectorAll("[required]"))
        .some(function (campo) {
            return campo.value.trim() === "";
        });

    mensajeValidacion.textContent = faltanCampos
        ? "Debe ingresar todos los campos para poder continuar."
        : "Revise los datos ingresados. Hay campos con un formato inválido.";
    mensajeValidacion.hidden = false;
}, true);

formularioAlta.addEventListener("input", function () {
    mensajeValidacion.hidden = true;
});

formularioAlta.addEventListener("reset", function () {
    mensajeValidacion.hidden = true;
    actualizarFechaMaxima();
});
