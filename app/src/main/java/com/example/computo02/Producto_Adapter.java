package com.example.computo02;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Producto_Adapter extends RecyclerView.Adapter<Producto_Adapter.ProductoVH> {

    ArrayList<Producto> data;


    private MainActivity activity; // Guardamos la referencia

    public Producto_Adapter(ArrayList<Producto> data, MainActivity activity) {
        this.data = data;
        this.activity = activity;
    }

    public Producto_Adapter(ArrayList<Producto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_item,parent,false);

        return new ProductoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {

        Producto p = data.get(position);

        holder.img.setImageResource(p.img);
        holder.tvNombre.setText(p.nombre);
        holder.tvPrecio.setText("precio $"+ p.precio);

        if (p.cantidad >=1){
            holder.tvCantidad.setText("Cantidad "+p.cantidad);
            holder.tvSubtotal.setText("Subtotal "+p.subtota());

            holder.btn.setOnClickListener(v -> {
                data.remove(p);
                notifyItemRemoved(position);
            });
        }
        else {


            holder.btn.setText("Agregar");
            holder.btn.setOnClickListener(v -> {
                activity.agregarAlCarrito(p);
            });

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ProductoVH extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvNombre, tvPrecio, tvCantidad,tvSubtotal;
        Button btn;
        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.ivAvatar);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            tvSubtotal= itemView.findViewById(R.id.tvSubtotal);
            btn = itemView.findViewById(R.id.btnEliminar);

        }
    }
}
