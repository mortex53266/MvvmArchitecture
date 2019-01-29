package com.power.mortex.mvvm.ui.login;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.ui.base.BaseViewModel;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

import static android.text.TextUtils.isEmpty;
import static com.power.mortex.mvvm.data.model.api.login.LoginRequest.ServerLoginRequest;


/**
 * Created by Morteza Rahimi on 08/07/17.
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email) {
        // validate email and password
        if (isEmpty(email)) {
            return false;
        }
        return true;
    }

    public void login(String phone, Boolean isGiftoUser) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new ServerLoginRequest(phone, isGiftoUser))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getNewUser()))
//                                response.getAccessToken(),
//                                response.getUserId(),
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                                response.getUserName(),
//                                response.getUserEmail(),
//                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getDataManager().setUserPhone(phone);
                    getNavigator().openVerifyActivity(response.getNewUser());
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public void onServerLoginClick() {
        getNavigator().login();
    }
}
