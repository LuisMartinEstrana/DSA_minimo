package com.example.minimo2;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.minimo2.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API<userValor> {

    //Todas las peticiones que haremos a la API
    //Queremos la api de solo una persona

    @GET("/users/LuisMartinEstrana")
    Call <Users> getUsers();//Recibimos los objetos donde tenemos una lista de elemento

    @GET("/users/LuisMartinEstrana/repos")
    Call <Repositoris> getRepositoris(); //Recibimos los objetos donde tenemos una lista de elemento

}
