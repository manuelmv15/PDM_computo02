package com.example.computo02;

public class Producto {

    public int img;

    public String nombre;

    public Double precio;

    public int cantidad;


    public Producto() {

    }

    public Producto(int img, String nombre, Double precio) {
        this.img = img;
        this.nombre = nombre;
        this.precio = precio;
    }

    public double subtota() {
        return precio * cantidad;
    }
}

