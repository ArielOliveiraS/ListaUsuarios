package com.example.helpieteste.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpieteste.R;
import com.example.helpieteste.model.Usuario;
import com.example.helpieteste.view.interfaces.OnClickUsuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {

    private List<Usuario> usuarioList;
    private OnClickUsuario listener;

    public UsuarioAdapter(List<Usuario> usuarioList, OnClickUsuario listener) {
        this.usuarioList = usuarioList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Usuario usuario = usuarioList.get(position);

        holder.onBind(usuario);

        holder.itemView.setOnClickListener(v -> {
            listener.onClickUsuario(usuario);
        });
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public void update(List<Usuario> usuarioList) {
        this.usuarioList.clear();
        this.usuarioList = usuarioList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private TextView txtEmail;
        private TextView txtCidade;
        private TextView txtId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCidade = itemView.findViewById(R.id.textViewCity);
            txtEmail = itemView.findViewById(R.id.textViewEmail);
            txtId = itemView.findViewById(R.id.textViewID);
            txtNome = itemView.findViewById(R.id.txtNome);
        }

        public void onBind(Usuario usuario) {
            txtNome.setText(usuario.getName());
            txtId.setText(usuario.getId());
            txtEmail.setText(usuario.getEmail());
            txtCidade.setText(usuario.getCity());

        }
    }
}
