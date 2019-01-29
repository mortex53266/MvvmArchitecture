package com.power.mortex.mvvm.ui.splash;

import android.content.Intent;

public interface SplashNavigator {

    void openMain();

    void openLogin();

    void openIntro();

    void handleIntent(Intent intent);
}
