package com.power.mortex.mvvm.ui.verifySms;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class VerifyPinActivityModule {

    @Provides
    VerifyPinViewModel provideVerifyPinViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new VerifyPinViewModel(dataManager,schedulerProvider);
    }
}
