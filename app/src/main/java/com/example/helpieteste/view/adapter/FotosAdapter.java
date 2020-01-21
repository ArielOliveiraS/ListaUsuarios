package com.example.helpieteste.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpieteste.R;
import com.example.helpieteste.model.Fotos;
import com.example.helpieteste.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.ViewHolder> {
    private List<Fotos> fotosList;

    public FotosAdapter(List<Fotos> fotosList) {
        this.fotosList = fotosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fotos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Fotos fotos = fotosList.get(position);
        holder.onBind(fotos);
    }

    @Override
    public int getItemCount() {
        return fotosList.size();
    }

    public void update(List<Fotos> fotosList) {
        this.fotosList.clear();
        this.fotosList = fotosList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotos;
        private TextView txtTituloFotos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotos = itemView.findViewById(R.id.imgBanner);
            txtTituloFotos = itemView.findViewById(R.id.tituloFoto);
        }


        public void onBind(Fotos fotos) {

            Picasso.get().load(fotos.getThumbnailUrl()).into(imgFotos);
            txtTituloFotos.setText(fotos.getTitle());
        }
    }
}
