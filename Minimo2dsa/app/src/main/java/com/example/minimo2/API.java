package com.example.minimo2;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.minimo2.models.*;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API<userValor> {

    @Override
    //Todas las peticiones que haremos a la API
    //Queremos la api de solo una persona
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    String userValor = preferences.getString("user","");

    @GET("/users/"+ userValor)
    Call <Users> getUsers(); //Recibimos los objetos donde tenemos una lista de elemento

    @GET("/users/"+userValor+"/repos")
    Call <Repositoris> getRepositoris(); //Recibimos los objetos donde tenemos una lista de elemento

}
