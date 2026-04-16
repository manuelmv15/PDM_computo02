package com.example.computo02.entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "facturas",
        foreignKeys = @ForeignKey(entity = Clientes.class, parentColumns = "idClientes",
                childColumns = "idClientes",
                onDelete = ForeignKey.RESTRICT
        ))
public class Facturas {
    @PrimaryKey(autoGenerate = true)
    public int idFactura;
    public int idClientes;
    public String fecha;
}
