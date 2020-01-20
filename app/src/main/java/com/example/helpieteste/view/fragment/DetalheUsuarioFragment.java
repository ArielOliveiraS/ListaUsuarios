package com.example.helpieteste.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helpieteste.R;
import com.example.helpieteste.model.Usuario;

import static com.example.helpieteste.view.fragment.UsuariosFragment.USUARIO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheUsuarioFragment extends Fragment {
    private TextView txtId;
    private TextView txtName;
    private TextView txtEmail;
    private TextView txtCity;
    private TextView txtUsername;
    private TextView txtStreet;
    private TextView txtSuite;
    private TextView txtZipcode;


    public DetalheUsuarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_usuario, container, false);
        initViews(view);

        if (getArguments() != null){
            Usuario usuario = getArguments().getParcelable(USUARIO_KEY);

            txtId.setText(usuario.getId());
            txtName.setText(usuario.getName());
            txtEmail.setText(usuario.getEmail());
            txtCity.setText(usuario.getCity());
            txtUsername.setText(usuario.getUsername());
            txtStreet.setText(usuario.getStreet());
            txtSuite.setText(usuario.getSuite());
            txtZipcode.setText(usuario.getZipcode());
        }

        return view;
    }

    public void initViews(View view) {
        txtId = view.findViewById(R.id.detalheId);
        txtName = view.findViewById(R.id.detalheNome);
        txtEmail = view.findViewById(R.id.detalheEmail);
        txtCity = view.findViewById(R.id.detalheCity);
        txtUsername = view.findViewById(R.id.detalheUsername);
        txtStreet = view.findViewById(R.id.detalheStreet);
        txtSuite = view.findViewById(R.id.detalheSuite);
        txtZipcode = view.findViewById(R.id.detalheZipcode);
    }

}
