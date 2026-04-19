package com.example.computo02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Producto> Productos, Carrito;

    producto_adapter adapterProducto, adapterCarrito;


    Spinner spCategoria;
    ArrayList<String> listCategoria;
    ArrayAdapter<String> arrayAdapter;
    EditText etCantidad;
    RecyclerView rvCarrito, rvProductos;


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


        spCategoria = findViewById(R.id.spCategoria);
        etCantidad = findViewById(R.id.etCantidad);
        rvCarrito = findViewById(R.id.rvCarrito);
        rvProductos = findViewById(R.id.rvProductos);


        Productos = new ArrayList<>();

        Productos.add(new Producto("musica", "guitarra", 50.50, R.drawable.img_musica));
        Productos.add(new Producto("tecnologia", "pc", 999.99, R.drawable.img_tecnologia));
        Productos.add(new Producto("vehiculo", "corolla", 5999.99, R.drawable.img_vehiculo));


        adapterProducto = new producto_adapter(this, Productos);
        rvProductos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        Carrito = new ArrayList<>();
        adapterCarrito = new producto_adapter(this, Carrito);
        rvCarrito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvCarrito.setAdapter(adapterCarrito);



        rvProductos.setAdapter(adapterProducto);
        listCategoria = new ArrayList<>();

        for (Producto p :
                Productos) {

            listCategoria.add(p.categoria);

        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listCategoria);
        spCategoria.setAdapter(arrayAdapter);


    }

    public void agregar(Producto p) {

        int cantidad = 0;


        String strCantidad = etCantidad.getText().toString();

        Log.i("DEBUG", "catidad str->" + strCantidad);
        try {
            cantidad = Integer.parseInt(strCantidad);

        } catch (Exception e) {
            Log.i("DEBUG", e.toString());
        }


        if (cantidad < 1) {
            Toast.makeText(this, "El numero debe ser entero positivo", Toast.LENGTH_SHORT).show();
            return;
        }

        p.cantidad = cantidad;
        Carrito.add(p);
        adapterCarrito.notifyDataSetChanged();


    }

    public void Comprar(View view) {

        double total =0;

        for (Producto p:
             Carrito) {
            total += p.subTotal();
        }

        Toast.makeText(this, "total-> " + String.valueOf(total), Toast.LENGTH_SHORT).show();

        etCantidad.setText("Total a pagar-> "+ total);
        Carrito.clear();
        adapterCarrito.notifyDataSetChanged();
    }
}