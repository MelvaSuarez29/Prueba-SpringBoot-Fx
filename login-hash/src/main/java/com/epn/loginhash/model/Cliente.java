package com.epn.loginhash.model;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String contraseniaHash;
    private String direccion;
    private String rol;

    public Cliente() {}

    public Cliente(String nombre, String correo, String telefono, String contraseniaHash, String direccion, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseniaHash = contraseniaHash;
        this.direccion = direccion;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getContraseniaHash() { return contraseniaHash; }
    public void setContraseniaHash(String contraseniaHash) { this.contraseniaHash = contraseniaHash; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}