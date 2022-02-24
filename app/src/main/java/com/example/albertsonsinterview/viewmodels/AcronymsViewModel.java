package com.example.albertsonsinterview.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.albertsonsinterview.models.AcronymResponse;
import com.example.albertsonsinterview.repositories.AcronymsRepository;

import java.util.List;

public class AcronymsViewModel extends AndroidViewModel {
    private AcronymsRepository acronymsRepository;
    private LiveData<List<AcronymResponse>> volumesResponseLiveData;

    public AcronymsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<AcronymResponse>> getAcronymsResponseLiveData(String keyword) {
        acronymsRepository = new AcronymsRepository();
        acronymsRepository.searchVolumes(keyword);
        volumesResponseLiveData = acronymsRepository.getAcronymResponseLiveData();
        return volumesResponseLiveData;
    }
}
