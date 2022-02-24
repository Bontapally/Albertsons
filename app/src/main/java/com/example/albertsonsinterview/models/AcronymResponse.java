package com.example.albertsonsinterview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcronymResponse {

    @SerializedName("sf")
    @Expose
    private String shortForm;
    @SerializedName("lfs")
    @Expose
    private List<LongForm> longForms = null;

    public String getShortForm() {
        return shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    public List<LongForm> getLongForms() {
        return longForms;
    }

    public void setLfs(List<LongForm> longForms) {
        this.longForms = longForms;
    }

}
