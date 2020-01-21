package com.example.helpieteste.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.helpieteste.model.Fotos;
import com.example.helpieteste.repository.FotosRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FotosViewModel extends AndroidViewModel {

    public FotosViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<List<Fotos>> listaFotos = new MutableLiveData<>();
    private FotosRepository repository = new FotosRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public LiveData<List<Fotos>> retornaFotos() {
        return this.listaFotos;
    }

    public void buscaFotos() {
        disposable.add(
                //Chama o método a partir do repository
                repository.obterListaFotos(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(fotosResposta -> listaFotos.setValue(fotosResposta.getFotos()),
                                throwable -> {
                                    Log.i("LOG", "busca fotos" + throwable.getMessage());
                                })

        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}


