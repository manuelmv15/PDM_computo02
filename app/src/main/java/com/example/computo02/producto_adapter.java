package com.example.computo02;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class producto_adapter extends RecyclerView.Adapter<producto_adapter.ProductoVH> {

    ArrayList<Producto> data;
    MainActivity activity;

    public producto_adapter(MainActivity activity, ArrayList<Producto> data) {

        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ProductoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {

        Producto p = data.get(position);


        holder.ivAvater.setImageResource(p.img);

        holder.tvNombre.setText(p.nombre);
        holder.tvPrecio.setText(String.valueOf(p.precio));

        Log.i("DEBUG",String.valueOf(p.cantidad));

        if (p.cantidad<1) {

            holder.btnAccion.setText("agregar");
            holder.tvCatidad.setText("");
            holder.btnAccion.setOnClickListener(v -> {
               activity.agregar(p);
            });

        }
        else {
            holder.btnAccion.setText("Borrar");
            holder.tvCatidad.setText("cantidad-> "+p.cantidad +" \nsubtotal-> "+p.subTotal());
            holder.btnAccion.setOnClickListener(v -> {
                data.remove(p);
                notifyItemChanged(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder{

         ImageView ivAvater;
         TextView tvNombre, tvPrecio, tvCatidad;
         Button btnAccion;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            ivAvater = itemView.findViewById(R.id.ivAvater);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCatidad = itemView.findViewById(R.id.tvCatidad);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            btnAccion = itemView.findViewById(R.id.btnAccion);
        }
    }
}
