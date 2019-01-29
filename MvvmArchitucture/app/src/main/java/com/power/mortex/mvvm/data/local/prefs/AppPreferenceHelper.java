package com.power.mortex.mvvm.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.di.PreferenceInfo;
import com.power.mortex.mvvm.utils.AppConstants;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";

    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";

    private static final String PREF_KEY_CURRENT_USER_PHONE = "PREF_KEY_CURRENT_USER_PHONE";

    private static final String PREF_KEY_CURRENT_HAS_SEEN_INTRO = "PREF_KEY_HAS_SEEN_INTRO";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferenceHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public String getUserPhone() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PHONE, null);
    }

    @Override
    public void setUserPhone(String phone) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PHONE, phone).apply();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public Boolean getHasSeenIntro() {
        return mPrefs.getBoolean(PREF_KEY_CURRENT_HAS_SEEN_INTRO, false);
    }

    @Override
    public void setHasSeenIntro(Boolean seen) {
        mPrefs.edit().putBoolean(PREF_KEY_CURRENT_HAS_SEEN_INTRO, seen).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }
}
