package com.example.minimo2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repositoris {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
