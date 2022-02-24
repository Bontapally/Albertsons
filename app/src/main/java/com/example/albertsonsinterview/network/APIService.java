package com.example.albertsonsinterview.network;


import com.example.albertsonsinterview.models.AcronymResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    //Acronyms
    @GET("/software/acromine/dictionary.py")
    Call<List<AcronymResponse>> getAcronyms(@Query("sf") String query);
}
