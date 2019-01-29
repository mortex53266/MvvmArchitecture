package com.power.mortex.mvvm.di.component;

import android.app.Application;

import com.power.mortex.mvvm.MvvmApp;
import com.power.mortex.mvvm.di.builder.ActivityBuilder;
import com.power.mortex.mvvm.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
