package com.power.mortex.mvvm.ui.verifySms;

public interface VerifyPinNavigator {

    void handelError(Throwable throwable);
    void verifyPin();
    void decideMainGetNiceName();
}
