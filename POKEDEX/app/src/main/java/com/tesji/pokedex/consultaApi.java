package com.tesji.pokedex;

import com.tesji.pokedex.Modelo.ModeloRetorno;
import com.tesji.pokedex.Modelo.Pokedex;
import com.tesji.pokedex.interfaces.peticiones;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class consultaApi {
    public static String URL = "https://pokeapi.co/api/v2/";
    public static Retrofit varRetro;
    ModeloRetorno modeloRetorno = new ModeloRetorno();
    public void respuesta(String id){
        varRetro = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        peticiones consApi = varRetro.create(peticiones.class);

        Call<Pokedex> call = consApi.consultar(id);

        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                try {
                    if (response.isSuccessful()) {
                        Pokedex pokedex = response.body();
                        modeloRetorno.setId(pokedex.getId());
                        modeloRetorno.setName(pokedex.getName());
                        modeloRetorno.setHeight(pokedex.getHeight());
                        modeloRetorno.setWeight(pokedex.getWeight());
                        modeloRetorno.setFront_default(pokedex.getSprites().getFront_default()); // Corrección del método setFront_default

                    } else {
                        System.out.println("mal");
                        System.out.println(call);
                    }
                }catch (Exception ex){
                    System.out.println("UWUn´t" + ex);
                }
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                System.out.println("UWUn´t " + t);

            }
        });
    }
}
