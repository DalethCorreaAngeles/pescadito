package com.example.pescadito.model;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Combinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private static String nombre ;

    private String  descripcion;

    private double precio;

    private boolean disponible;

    @Column(nullable = false)
    private String  catergoria;


    // Contructor
    public Combinado(Integer id, String nombre, String descripcion, double precio, boolean disponible, String catergoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.catergoria = catergoria;
    }

    // Getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getNombre() {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCatergoria() {
        return catergoria;
    }

    public void setCatergoria(String catergoria) {
        this.catergoria = catergoria;
    }
}


