package com.power.mortex.mvvm.ui.login;

/**
 * Created by Morteza Rahimi on 08/07/17.
 */

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void openVerifyActivity(Boolean newUser);
}
