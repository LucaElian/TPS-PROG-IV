package com.example.tp6.entidad;

import androidx.annotation.NonNull;

public class Contacto {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private TipoContacto tipoTelefono;
    private String mail;
    private TipoContacto tipoMail;
    private String direccion;
    private String fechaNacimiento;
    private String nivelEstudios;
    private boolean deporte;
    private boolean musica;
    private boolean arte;
    private boolean tecnologia;
    private boolean recibirInfo;

    public Contacto() { }

    public Contacto(String nombre, String apellido, String telefono, TipoContacto tipoTelefono,
                    String mail, TipoContacto tipoMail, String direccion, String fechaNacimiento,
                    String nivelEstudios, boolean deporte, boolean musica, boolean arte,
                    boolean tecnologia, boolean recibirInfo) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoTelefono = tipoTelefono;
        this.mail = mail;
        this.tipoMail = tipoMail;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelEstudios = nivelEstudios;
        this.deporte = deporte;
        this.musica = musica;
        this.arte = arte;
        this.tecnologia = tecnologia;
        this.recibirInfo = recibirInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoContacto getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoContacto tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public TipoContacto getTipoMail() {
        return tipoMail;
    }

    public void setTipoMail(TipoContacto tipoMail) {
        this.tipoMail = tipoMail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public boolean isDeporte() {
        return deporte;
    }

    public void setDeporte(boolean deporte) {
        this.deporte = deporte;
    }

    public boolean isMusica() {
        return musica;
    }

    public void setMusica(boolean musica) {
        this.musica = musica;
    }

    public boolean isArte() {
        return arte;
    }

    public void setArte(boolean arte) {
        this.arte = arte;
    }

    public boolean isTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(boolean tecnologia) {
        this.tecnologia = tecnologia;
    }

    public boolean isRecibirInfo() {
        return recibirInfo;
    }

    public void setRecibirInfo(boolean recibirInfo) {
        this.recibirInfo = recibirInfo;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + mail;
    }
}