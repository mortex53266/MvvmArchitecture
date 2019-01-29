package com.power.mortex.mvvm.data.remote;

import com.power.mortex.mvvm.data.model.api.login.LoginResponse;
import com.power.mortex.mvvm.data.model.api.verifyPin.VerifyPinResponse;

import io.reactivex.Single;

import static com.power.mortex.mvvm.data.model.api.login.LoginRequest.ServerLoginRequest;
import static com.power.mortex.mvvm.data.model.api.verifyPin.VerifyPinRequest.VerifyPin;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public interface ApiHelper {

//    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);
//
//    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);
//
//    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(ServerLoginRequest request);

    Single<VerifyPinResponse> verifyPinApiCall(VerifyPin request);

    ApiHeader getApiHeader();
//
//    Single<BlogResponse> getBlogApiCall();
//
//    Single<OpenSourceResponse> getOpenSourceApiCall();
}
