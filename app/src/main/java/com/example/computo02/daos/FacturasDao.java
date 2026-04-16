package com.example.computo02.daos;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.computo02.entitys.Clientes;
import com.example.computo02.entitys.Facturas;
import com.example.computo02.entitys.relations.ClientesFacturas;

import java.util.List;

@Dao
public interface FacturasDao {
    @Insert
    long inserCliente(Clientes clientes);

    @Insert
    long insertFacturas(Facturas facturas);

    @Query("Select * from clientes")
    List<Clientes> getClientes();

    @Query("Select * from facturas")
    List<Facturas> getFacturas();

    @Transaction
    @Query("Select * from clientes")
    List<ClientesFacturas> getClientesFacturas();
}