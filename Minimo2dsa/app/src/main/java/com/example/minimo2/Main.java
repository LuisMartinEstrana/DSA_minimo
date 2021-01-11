package com.example.minimo2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minimo2.models.Repositoris;
import com.example.minimo2.models.Users;
import com.example.minimo2.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends AppCompatActivity {

    String Login;
    API api;
    List<Usuario> usuarios;
    String Repo;

    private ProgressBar progressBar;
    private RecyclerView Recyclers;
    private TextView Followers;
    private TextView Following;
    private String userValor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        userValor = preferences.getString("user", "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
        progressBar = findViewById(R.id.progressBar);
        Followers = findViewById(R.id.Followers);
        Following = findViewById(R.id.Following);
        progressBar.setVisibility(View.VISIBLE);// muestra progress bar
        //como presentar la lista de articulos
        Recyclers = (RecyclerView) findViewById(R.id.Recycler);
        Recyclers.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getRepos();

    }

    private void getRepos(){
        Call<Users> call = api.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users users = response.body();
                Repo = users.getLogin();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }

}
