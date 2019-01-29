package com.power.mortex.mvvm.ui.login;


import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Morteza Rahimi on 14/09/17.
 */
@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }
}
