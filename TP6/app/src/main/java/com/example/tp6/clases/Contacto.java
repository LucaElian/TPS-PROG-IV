package com.example.tp6.clases;

public class Contacto {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoTelefono;
    private String mail;
    private String tipoMail;
    private String direccion;
    private String fechaNacimiento;
    private String nivelEstudios;
    private boolean deporte;
    private boolean musica;
    private boolean arte;
    private boolean tecnologia;
    private boolean recibirInfo;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String apellido, String telefono, String tipoTelefono, String mail, String tipoMail, String direccion, String fechaNacimiento, String nivelEstudios, boolean deporte, boolean musica, boolean arte, boolean tecnologia, boolean recibirInfo) {
        this.id = id;
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

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTipoMail() {
        return tipoMail;
    }

    public void setTipoMail(String tipoMail) {
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

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipoTelefono='" + tipoTelefono + '\'' +
                ", mail='" + mail + '\'' +
                ", tipoMail='" + tipoMail + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nivelEstudios='" + nivelEstudios + '\'' +
                ", deporte=" + deporte +
                ", musica=" + musica +
                ", arte=" + arte +
                ", tecnologia=" + tecnologia +
                ", recibirInfo=" + recibirInfo +
                '}';
    }
}
