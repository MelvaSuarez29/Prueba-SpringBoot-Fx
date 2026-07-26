package com.epn.loginhash.model;

public class RegisterCliente {
    private String nombreCompleto;
    private String correoElectronico;
    private String Telefono;
    private String contrasenia;
    private String direccion;

    public RegisterCliente() {}

    public RegisterCliente(String nombreCompleto, String correoElectronico, String telefono, String contrasenia, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        Telefono = telefono;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
    }

    public String getNombreCompleto() {return nombreCompleto;}
    public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}
    public String getCorreoElectronico() {return correoElectronico;}
    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}
    public String getTelefono() {return Telefono;}
    public void setTelefono(String telefono) {Telefono = telefono;}
    public String getContrasenia() {return contrasenia;}
    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    @Override
    public String toString() {
        return "RegisterCliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
