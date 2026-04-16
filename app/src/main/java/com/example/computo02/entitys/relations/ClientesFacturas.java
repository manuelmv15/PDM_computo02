package com.example.computo02.entitys.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.computo02.entitys.Clientes;
import com.example.computo02.entitys.Facturas;

import java.util.List;

public class ClientesFacturas {
    @Embedded
    public Clientes clientes;
    @Relation(parentColumn = "idClientes",
            entityColumn = "idClientes")
    public List<Facturas> facturas;

}
