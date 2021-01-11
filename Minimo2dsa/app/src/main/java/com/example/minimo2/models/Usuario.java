package com.example.minimo2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Usuario {
    @SerializedName("user")
    @Expose
    private List <Users> user = null;

    @SerializedName("repositoris")
    @Expose
    private List <Repositoris> repositoris = null;

    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
    }

    public List<Repositoris> getRepositoris() {
        return repositoris;
    }

    public void setRepositoris(List<Repositoris> repositoris) {
        this.repositoris = repositoris;
    }
}
