package com.example.computo02.basededatos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.computo02.daos.FacturasDao;
import com.example.computo02.entitys.Clientes;
import com.example.computo02.entitys.Facturas;

@Database(entities = {Clientes.class, Facturas.class}, version = 1, exportSchema = true)

public abstract class AppDataBase extends RoomDatabase {
    public abstract FacturasDao facturasDao();
}
