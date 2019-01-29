package com.power.mortex.mvvm.di.builder;


import com.power.mortex.mvvm.ui.login.LoginActivity;
import com.power.mortex.mvvm.ui.login.LoginActivityModule;
import com.power.mortex.mvvm.ui.splash.SplashActivity;
import com.power.mortex.mvvm.ui.splash.SplashActivityModule;
import com.power.mortex.mvvm.ui.verifySms.VerifyPinActivity;
import com.power.mortex.mvvm.ui.verifySms.VerifyPinActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = {
//            FeedActivityModule.class,
//            BlogFragmentProvider.class,
//            OpenSourceFragmentProvider.class})
//    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = VerifyPinActivityModule.class)
    abstract VerifyPinActivity bindVerifyPinActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

//    @ContributesAndroidInjector(modules = {
//            MainActivityModule.class,
//            AboutFragmentProvider.class,
//            RateUsDialogProvider.class})
//    abstract MainActivity bindMainActivity();

//    @ContributesAndroidInjector(modules = SplashActivityModule.class)
//    abstract SplashActivity bindSplashActivity();
}
