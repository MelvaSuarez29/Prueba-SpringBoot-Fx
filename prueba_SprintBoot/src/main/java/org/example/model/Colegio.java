package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name ="colegio")

public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private String num_estudiantes;
    private String director;

    public Colegio(){}
    public Colegio(String tipo, String num_estudiantes, String director, String ubicacion, String nombre) {
        this.tipo = tipo;
        this.num_estudiantes = num_estudiantes;
        this.director = director;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }

    public Colegio(Integer id, String nombre, String ubicacion, String tipo, String num_estudiantes, String director) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.num_estudiantes = num_estudiantes;
        this.director = director;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public String getNum_estudiantes() {return num_estudiantes;}
    public void setNum_estudiantes(String num_estudiantes) {this.num_estudiantes = num_estudiantes;}
    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}

    @Override
    public String toString() {
        return "Colegios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", num_estudiantes='" + num_estudiantes + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
