package com.power.mortex.mvvm.data.model.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @Expose
    @SerializedName("is_new_user")
    private Boolean newUser;


    public Boolean getNewUser() {
        return newUser;
    }
}
