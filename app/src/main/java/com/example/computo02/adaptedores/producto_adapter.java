package com.example.computo02.adaptedores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.computo02.R;
import com.example.computo02.modelos.Producto;

import java.util.ArrayList;

public class producto_adapter extends RecyclerView.Adapter<producto_adapter.ProdcutoVH> {

   private  ArrayList<Producto> data;

   public producto_adapter(ArrayList<Producto> data){
       this.data = data;
   }


    @NonNull
    @Override
    public producto_adapter.ProdcutoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_adapter,parent,false);
        return new ProdcutoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull producto_adapter.ProdcutoVH holder, int position) {

       Producto p = data.get(position);

       holder.nombre.setText(p.nombre);
       holder.precio.setText(String.valueOf(p.precio));
       holder.stock.setText(String.valueOf(p.stock));
       holder.img.setImageResource(p.img);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProdcutoVH extends RecyclerView.ViewHolder {

       public ImageView img;

       public TextView nombre, precio, stock;
        public Button btn;


        public ProdcutoVH(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.ivAvatar);
            nombre = itemView.findViewById(R.id.tvNombre);
            precio = itemView.findViewById(R.id.tvDetalle);
            stock = itemView.findViewById(R.id.tvstock);
            btn = itemView.findViewById(R.id.btnEliminar);
        }
    }
}
