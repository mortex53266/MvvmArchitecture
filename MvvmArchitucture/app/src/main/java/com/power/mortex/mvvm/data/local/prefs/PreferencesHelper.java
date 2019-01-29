package com.power.mortex.mvvm.data.local.prefs;


import static com.power.mortex.mvvm.data.DataManager.LoggedInMode;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public interface PreferencesHelper {

    String getAccessToken();

    String getUserPhone();

    void setUserPhone(String phone);

    Boolean getHasSeenIntro();

    void setHasSeenIntro(Boolean seen);

    void setAccessToken(String accessToken);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    Long getCurrentUserId();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
