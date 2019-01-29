package com.power.mortex.mvvm.data.model.api.verifyPin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyPinResponse {

    @Expose
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }
}
