package com.power.mortex.mvvm.ui.splash;

import android.content.Intent;
import android.os.Handler;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.ui.base.BaseViewModel;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {


    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void secondTask(Intent intent) {

        final Handler splashHandler = new Handler();
        splashHandler.postDelayed(() -> {

            if (getDataManager().getHasSeenIntro()) {
                if (getDataManager().getAccessToken() != null) {

                    if (intent.getStringExtra("type") != null) {
                        getNavigator().handleIntent(intent);
                    } else {
                        getNavigator().openMain();
                    }
                } else {
                    getNavigator().openLogin();
                }
            } else {
                getNavigator().openIntro();
            }

        }, 5000);
    }

}
