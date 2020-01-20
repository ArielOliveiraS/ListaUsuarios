package com.example.helpieteste.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpieteste.R;
import com.example.helpieteste.model.Usuario;
import com.example.helpieteste.view.adapter.UsuarioAdapter;
import com.example.helpieteste.view.interfaces.OnClickUsuario;
import com.example.helpieteste.viewmodel.UsuarioViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsuariosFragment extends Fragment implements OnClickUsuario {

    private RecyclerView recyclerView;
    private UsuarioViewModel viewModel;
    private List<Usuario> usuárioList = new ArrayList<>();
    private UsuarioAdapter adapter;

    public static final String USUARIO_KEY = "usuario";

    public UsuariosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        viewModel.buscaUsuario();

        viewModel.retornaUsuario().observe(this, usuarioRetornado->{
            adapter.update(usuarioRetornado);
        });


        return view;
    }

    private void initViews(View view){
        recyclerView = view.findViewById(R.id.recyclerViewUsuario);
       // adapter = new NoticiaRecyclerViewAdapter(noticias);
        viewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
    }

    @Override
    public void onClickUsuario(Usuario usuario) {
        Intent intent = new Intent(getContext(), DetalheUsuarioFragment.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(USUARIO_KEY, usuario);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
