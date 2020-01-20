package com.example.helpieteste.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.helpieteste.model.Usuario;
import com.example.helpieteste.repository.UsuarioRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UsuarioViewModel extends AndroidViewModel {

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<List<Usuario>> listaUsuario = new MutableLiveData<>();
    private UsuarioRepository repository = new UsuarioRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public LiveData<List<Usuario>> retornaUsuario() {
        return this.listaUsuario;
    }

    public void buscaUsuario() {
        disposable.add(
                //Chama o método a partir do repository
                repository.obterListaUsuario(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(usuarioResposta -> listaUsuario.setValue(usuarioResposta.getUsuarios()),
                                throwable -> {
                                    Log.i("LOG", "busca usuários" + throwable.getMessage());
                                })

        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
