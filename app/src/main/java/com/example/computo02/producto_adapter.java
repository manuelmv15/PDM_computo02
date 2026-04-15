package com.example.computo02;

import static com.example.computo02.R.*;

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

    private MainActivity activity;

    public producto_adapter(MainActivity activity, ArrayList<Producto> data) {
        this.activity = activity;
        this.data = data;
    }

    public producto_adapter(ArrayList<Producto> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ProductoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {

        Producto p = data.get(position);

        holder.ivAvatar.setImageResource(p.img);
        holder.tvNombre.setText(p.nombre);
        holder.tvPrecio.setText("precio $" + p.precio);

        holder.tvCantidad.setText("Cantidad " + p.cantidad);
        holder.tvSubtotal.setText("Subtotal " + p.subtota());

        holder.btnEliminar.setOnClickListener(v -> {
            data.remove(p);
            notifyItemRemoved(position);
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvNombre, tvPrecio, tvCantidad, tvSubtotal;

        Button btnEliminar;


        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            tvSubtotal = itemView.findViewById(R.id.tvSubtotal);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }

    }
}
