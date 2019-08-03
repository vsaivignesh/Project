package com.example.libsys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface logInt {
    @GET("/login.php")
    Call<List<lIn>> getUsers();
}
