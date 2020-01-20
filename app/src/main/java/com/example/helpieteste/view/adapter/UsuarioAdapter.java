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
    private List<Usuario> usuárioList;
    private OnClickUsuario listener;

    public UsuarioAdapter(List<Usuario> usuárioList, OnClickUsuario listener) {
        this.usuárioList = usuárioList;
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
        final Usuario usuário = usuárioList.get(position);
        holder.onBind(usuário);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickUsuario(usuário);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuárioList.size();
    }

    public void update(List<Usuario> noticiasList) {
        this.usuárioList.clear();
        this.usuárioList = noticiasList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private TextView txtEmail;
        private TextView txtCidade;
        private TextView txtId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCidade = itemView.findViewById(R.id.detalheNome);
            txtEmail = itemView.findViewById(R.id.textViewEmail);
            txtId = itemView.findViewById(R.id.textViewID);
            txtNome = itemView.findViewById(R.id.detalheNome);
        }

        public void onBind(Usuario usuário) {

            txtNome.setText(usuário.getName());
            txtId.setText(usuário.getId());
            txtEmail.setText(usuário.getEmail());
            txtCidade.setText(usuário.getCity());

        }
    }
}
