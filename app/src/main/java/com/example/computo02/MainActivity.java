package com.example.computo02;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.computo02.basededatos.AppDataBase;
import com.example.computo02.daos.FacturasDao;
import com.example.computo02.entitys.Clientes;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    private AppDataBase appDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("data_temp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token", "12345");
        editor.apply();

        this.lblMensaje = findViewById(R.id.tvMostrar);

        lblMensaje.setText(sharedPreferences.getString("Token","No encontrado"));

        appDataBase = Room.databaseBuilder(
                        getApplicationContext(),AppDataBase.class, "db_facturas").
                allowMainThreadQueries().
                build();

        Clientes clientes = new Clientes();
        clientes.nombre = "Cristian";
        //clientes.idClientes = 1;

        FacturasDao facturasDao = appDataBase.facturasDao();
        facturasDao.inserCliente(clientes);
    }
}