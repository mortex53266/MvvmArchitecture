package com.power.mortex.mvvm.ui.verifySms;

import android.text.TextUtils;

import com.power.mortex.mvvm.data.DataManager;
import com.power.mortex.mvvm.data.model.api.verifyPin.VerifyPinRequest;
import com.power.mortex.mvvm.ui.base.BaseViewModel;
import com.power.mortex.mvvm.utils.rx.SchedulerProvider;

public class VerifyPinViewModel extends BaseViewModel<VerifyPinNavigator> {

    public VerifyPinViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public boolean isPinValid(String pin) {
        // validate pin
        return !TextUtils.isEmpty(pin);
    }

    public void verifyPin(String phoneNumber, String pin, String fcmToken, Boolean isGifto) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .verifyPinApiCall(new VerifyPinRequest.VerifyPin(phoneNumber, pin, fcmToken, isGifto))
                .doOnSuccess(response -> getDataManager()
                        .setAccessToken("Token " + response.getToken()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().decideMainGetNiceName();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handelError(throwable);
                }));
    }


    public void onVerifyPin() {
        getNavigator().verifyPin();
    }

}
