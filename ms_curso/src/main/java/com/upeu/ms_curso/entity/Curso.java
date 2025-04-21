package com.upeu.ms_curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer numeroEstudiantes;

    // Constructor sin parámetros (requerido por JPA)
    public Curso() {
    }

    // Constructor con parámetros (sin el id, ya que es autogenerado)
    public Curso(Integer id, String nombre, String descripcion, Integer numeroEstudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroEstudiantes = numeroEstudiantes;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public void setNumeroEstudiantes(Integer numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }

    // toString (opcional, pero útil para depuración)
    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroEstudiantes=" + numeroEstudiantes +
                '}';
    }
}
