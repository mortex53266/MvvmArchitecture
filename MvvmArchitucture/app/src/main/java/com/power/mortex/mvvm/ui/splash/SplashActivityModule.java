package com.power.mortex.mvvm.ui.splash;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new SplashViewModel(dataManager,schedulerProvider);
    }
}
