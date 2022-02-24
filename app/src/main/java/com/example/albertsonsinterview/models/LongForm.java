package com.example.albertsonsinterview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LongForm {

    @SerializedName("lf")
    @Expose
    private String longForm;
    @SerializedName("freq")
    @Expose
    private Integer freq;
    @SerializedName("since")
    @Expose
    private Integer since;
    @SerializedName("vars")
    @Expose
    private List<Variations> variations = null;

    public LongForm(String longForm, Integer freq, Integer since, List<Variations> variations) {
        this.longForm = longForm;
        this.freq = freq;
        this.since = since;
        this.variations = variations;
    }

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

    public List<Variations> getVars() {
        return variations;
    }

    public void setVars(List<Variations> variations) {
        this.variations = variations;
    }

}
