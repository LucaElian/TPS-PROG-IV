package com.example.tp6.entidad;

public enum TipoContacto {
    CASA("Casa"),
    TRABAJO("Trabajo"),
    MOVIL("Movil");

    private final String texto;

    TipoContacto(String texto) {
        this.texto = texto;
    }

    @Override
    public  String toString() {
        return texto;
    }
}