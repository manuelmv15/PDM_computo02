package com.example.computo02.entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clientes")
public class Clientes {
    @PrimaryKey(autoGenerate = true)
    public int idClientes;
    @ColumnInfo(name = "nombreCliente")
    public String nombre;

}
