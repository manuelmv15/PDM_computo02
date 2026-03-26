package com.example.computo02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvProducto;
    RecyclerView rvCarrito;

    EditText edCantidad;
    ArrayList<Producto> data;


    ArrayList<Producto> listaCarrito;

    Producto_Adapter adapter;

    Producto_Adapter adapterCarrito;


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


        edCantidad =findViewById(R.id.etComentario);

        rvProducto = findViewById(R.id.rvProducto);
        data = new ArrayList<>();
        data.add(new Producto(R.drawable.ic_launcher_foreground,"android",10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground,"android",10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground,"android",10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground,"android",10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground,"android",10.00));
        rvProducto.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapter = new Producto_Adapter(data,this);
        rvProducto.setAdapter(adapter);
        rvCarrito = findViewById(R.id.rvCarrito);



        rvCarrito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        listaCarrito = new ArrayList<>();
        adapterCarrito = new Producto_Adapter(listaCarrito);
        rvCarrito.setAdapter(adapterCarrito);

    }


    public void agregarAlCarrito(Producto p) {


        String strCantidad = edCantidad.getText().toString();
        int cantidad = 0;
        try {

             cantidad =  Integer.parseInt(strCantidad);
        } catch (Exception e) {




        }

        if (cantidad <1){

            Toast.makeText(this, "Solo numeros enteros", Toast.LENGTH_SHORT).show();
            return;
        }


        p.cantidad = cantidad;

        listaCarrito.add(p); // Añades a la lista del segundo RecyclerView
        adapterCarrito.notifyDataSetChanged(); // Le avisas al segundo adapter que hay datos nuevos
        Log.i("DEBG",p.nombre + " agregado");


    }


    public void FinalizarCompra(View view) {

        double Total = 0;



            if (listaCarrito.size()>0){
                for (Producto p:
                     listaCarrito) {

                    Total += p.subtota();
                }
            }

            listaCarrito.clear();

            adapterCarrito.notifyDataSetChanged();

        Toast.makeText(this, "Total: " + Total, Toast.LENGTH_SHORT).show();

    }
}