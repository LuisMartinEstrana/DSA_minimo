package com.example.minimo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minimo2.models.Repositoris;
import com.example.minimo2.models.Users;
import com.example.minimo2.models.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderData> {

    List<Usuario> listusuarios;
    int globalposition;
    public RecyclerViewAdapter(List<Usuario> listusuarios)
    {
        this.listusuarios = listusuarios;

    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,null,false);

        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolderData holder, int position) {
        //asignar los datos a cada componente del diseño
        Usuario usuario = listusuarios.get(position);

        holder.Repositorios.setText(usuario.getUser().get(0).getLogin());
        Picasso.with(holder.img.getContext()).load(""+ listusuarios.get(position).getUser().get(0).getAvatarUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() { return listusuarios.size(); }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        //Tenemos que hacer referencia a todos los datos de la lista de diseño -> imagen, TextView ...
        public ImageView img;
        public TextView Repositorios;
        public TextView Usuarios;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            //Elementos de referencia del diseño que creamos para imprimirlos para cada elemento
            img = itemView.findViewById(R.id.image);
            Repositorios = itemView.findViewById(R.id.repositoris);
            Usuarios = itemView.findViewById(R.id.usuarios);
            Repositorios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    globalposition = getAdapterPosition();
                }
            });
        }
    }

}
