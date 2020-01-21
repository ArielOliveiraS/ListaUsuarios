package com.example.helpieteste.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpieteste.R;
import com.example.helpieteste.model.Fotos;
import com.example.helpieteste.model.Usuario;
import com.example.helpieteste.view.adapter.FotosAdapter;
import com.example.helpieteste.view.adapter.UsuarioAdapter;
import com.example.helpieteste.viewmodel.FotosViewModel;
import com.example.helpieteste.viewmodel.UsuarioViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotosFragment extends Fragment {
    private RecyclerView recyclerView;
    private FotosViewModel viewModel;
    private List<Fotos> fotosList = new ArrayList<>();
    private FotosAdapter adapter;



    public FotosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fotos, container, false);
        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.buscaFotos();

        viewModel.retornaFotos().observe(this, fotoRetornada->{
            adapter.update(fotoRetornada);
        });


        return view;
    }

    private void initViews(View view){
        recyclerView = view.findViewById(R.id.recyclerViewFotos);
        viewModel = ViewModelProviders.of(this).get(FotosViewModel.class);
    }

}
