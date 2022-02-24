package com.example.albertsonsinterview.network;

import com.example.albertsonsinterview.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final long TIME_SLOT = 30;
    private static APIService apiService;
    private static APIClient restClient;

    private static APIClient getInstance() {
        if (restClient == null) {
            synchronized (APIClient.class) {
                if (restClient == null) {
                    restClient = new APIClient();
                }
            }
        }
        return restClient;
    }

    public static APIService getApiService(String baseUrl) {
        getInstance().setupRestClient(baseUrl);
        return apiService;
    }

    private void setupRestClient(String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        apiService = new retrofit2.Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class);
    }
}