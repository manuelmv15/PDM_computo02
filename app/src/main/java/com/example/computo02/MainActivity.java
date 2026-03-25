package com.example.computo02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.computo02.adaptedores.producto_adapter;
import com.example.computo02.modelos.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rv_producto;
    public ArrayList<Producto> data;

    public producto_adapter adapter;

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



        rv_producto = findViewById(R.id.rvProducto);


        data = new ArrayList<>();

        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img_1,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));

        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));
        data.add(new Producto(R.drawable.img,"papayarayada",10,10));




        //rv_producto.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        //rv_producto.setLayoutManager(new GridLayoutManager(this,2));
        //rv_producto.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        rv_producto.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        // 3) Adapter
        adapter = new producto_adapter(data);
        rv_producto.setAdapter(adapter);




    }
}