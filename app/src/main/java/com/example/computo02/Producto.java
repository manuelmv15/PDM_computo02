package com.example.computo02;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Producto {

    int img, cantidad;

    String nombre, categoria;

    double precio;

    public Producto(){}

    public Producto(String categoria, String nombre, double precio, int img) {
        this.categoria = categoria;
this   .img = img;
        this.nombre = nombre;
        this.precio = precio;
    }


    double subTotal(){
        return this .cantidad * this.precio;
    }

}
