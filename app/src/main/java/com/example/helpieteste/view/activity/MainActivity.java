package com.example.helpieteste.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.helpieteste.R;
import com.example.helpieteste.view.fragment.FotosFragment;
import com.example.helpieteste.view.fragment.UsuariosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_usuario, R.id.navigation_fotos)
                .build();

        navigationView.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.navigation_usuario);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_usuario:{
                replaceFragment(new UsuariosFragment());
                break;
            }
            case R.id.navigation_fotos:{
                replaceFragment(new FotosFragment());
                break;
            }
        }

        return true;
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

    }
}
