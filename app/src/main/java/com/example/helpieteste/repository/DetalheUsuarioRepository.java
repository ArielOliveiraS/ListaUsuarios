package com.example.helpieteste.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.helpieteste.model.UsuarioResposta;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Observable;

public class DetalheUsuarioRepository {

    public Observable<UsuarioResposta> obterPostsUsuario(Context context){

        try {
            //Cria um stream para ler o arquivo JSON
            AssetManager manager = context.getAssets();

            //Abre o arquivo JSON criado
            InputStream inputStream = manager.open("detalheusuario.json");

            //Pega o ponto de referencia(inputStream) do arquivo JSON e cria um array de Bites
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            //Inicio da utilização do GSON
            Gson gson = new Gson();

            /*Conversão do aqruivo JSON para objetos em Java, o parametro do método
            gson.fromJson espera o bufferedReader que é o array em bites do JSON, e a
            classe que deve representar esse dado.
             */
            UsuarioResposta resposta = gson.fromJson(reader, UsuarioResposta.class);

            //Retorno do método
            //O Observable.just irá retornar apenas um dado que nesse caso é um objeto do tipo NoticiaResposta
            return Observable.just(resposta);

        } catch (Exception ex) {
            ex.printStackTrace();
            return Observable.error(ex.getCause());
        }

    }
}


