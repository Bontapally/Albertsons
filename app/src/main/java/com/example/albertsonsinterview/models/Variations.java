package com.example.albertsonsinterview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variations {

    @SerializedName("lf")
    @Expose
    private String longForm;
    @SerializedName("freq")
    @Expose
    private Integer freq;
    @SerializedName("since")
    @Expose
    private Integer since;

    public String getLongForm() {
        return longForm;
    }

    public void setLongForm(String longForm) {
        this.longForm = longForm;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

}
