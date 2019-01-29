package com.power.mortex.mvvm.data;

import com.power.mortex.mvvm.data.local.prefs.PreferencesHelper;
import com.power.mortex.mvvm.data.remote.ApiHelper;

public interface DataManager extends ApiHelper, PreferencesHelper {

//    Observable<List<QuestionCardData>> getQuestionCardData();

//    Observable<Boolean> seedDatabaseOptions();
//
//    Observable<Boolean> seedDatabaseQuestions();

    void setUserAsLoggedOut();

    void updateApiHeader(String accessToken);

    void updateUserInfo(
            Boolean isNewUser);
//            Long userId,
//            LoggedInMode loggedInMode,
//            String userName,
//            String email,
//            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
