package com.example.albertsonsinterview.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.albertsonsinterview.models.AcronymResponse;
import com.example.albertsonsinterview.network.APIClient;
import com.example.albertsonsinterview.network.APIConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcronymsRepository {

    private final MutableLiveData<List<AcronymResponse>> acronymResponseLiveData;

    public AcronymsRepository() {
        acronymResponseLiveData = new MutableLiveData<>();
    }

    public void searchVolumes(String keyword) {
        APIClient.getApiService(APIConstants.BOOK_SEARCH_SERVICE_BASE_URL)
                .getAcronyms(keyword)
                .enqueue(new Callback<List<AcronymResponse>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<AcronymResponse>> call, @NonNull Response<List<AcronymResponse>> response) {
                        if (response.code() == 404) {
                            acronymResponseLiveData.postValue(null);
                        }
                        if (response.body() != null) {
                            acronymResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<AcronymResponse>> call, @NonNull Throwable t) {
                        acronymResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<List<AcronymResponse>> getAcronymResponseLiveData() {
        return acronymResponseLiveData;
    }
}
