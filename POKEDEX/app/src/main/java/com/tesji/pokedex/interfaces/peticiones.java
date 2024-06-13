package com.tesji.pokedex.interfaces;

import com.tesji.pokedex.Modelo.Pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface peticiones {

    @GET("pokemon/{id}")
    Call<Pokedex> consultar(@Path("id") String id);
}
