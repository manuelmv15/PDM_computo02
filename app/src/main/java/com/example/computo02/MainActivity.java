package com.example.computo02;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Producto> data;
    RecyclerView rvData;

    producto_adapter adapter;

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

        rvData = findViewById(R.id.rvData);


        data = new ArrayList<>();
        data = new ArrayList<>();
        data.add(new Producto(R.drawable.ic_launcher_foreground, "android", 10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground, "android", 10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground, "android", 10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground, "android", 10.00));
        data.add(new Producto(R.drawable.ic_launcher_foreground, "android", 10.00));

        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapter = new producto_adapter(this, data);
        rvData.setAdapter(adapter);
    }
}