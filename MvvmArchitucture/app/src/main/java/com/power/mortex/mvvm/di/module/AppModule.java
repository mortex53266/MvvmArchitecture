package com.power.mortex.mvvm.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.power.mortex.mvvm.data.AppDataManager;
import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.data.local.prefs.AppPreferenceHelper;
import com.power.mortex.mvvm.data.local.prefs.PreferencesHelper;
import com.power.mortex.mvvm.data.remote.ApiHelper;
import com.power.mortex.mvvm.data.remote.AppApiHelper;
import com.power.mortex.mvvm.di.ApiInfo;
import com.power.mortex.mvvm.di.DatabaseInfo;
import com.power.mortex.mvvm.di.PreferenceInfo;
import com.power.mortex.mvvm.utils.rx.AppSchedulerProvider;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.power.mortex.mvvm.BuildConfig.API_KEY;
import static com.power.mortex.mvvm.R.attr.fontPath;
import static com.power.mortex.mvvm.data.remote.ApiHeader.ProtectedApiHeader;
import static com.power.mortex.mvvm.utils.AppConstants.DB_NAME;
import static com.power.mortex.mvvm.utils.AppConstants.PREF_NAME;
import static uk.co.chrisjenx.calligraphy.CalligraphyConfig.Builder;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return API_KEY;
    }

//    @Provides
//    @Singleton
//    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
//        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
//                .build();
//    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new Builder()
                .setDefaultFontPath("fonts/IRANSansMobile_Light.ttff")
                .setFontAttrId(fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return DB_NAME;
    }

//    @Provides
//    @Singleton
//    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
//        return appDbHelper;
//    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferenceHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
