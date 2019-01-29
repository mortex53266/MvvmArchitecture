package com.power.mortex.mvvm.data.remote;

import com.power.mortex.mvvm.data.model.api.login.LoginResponse;
import com.power.mortex.mvvm.data.model.api.verifyPin.VerifyPinResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

import static com.power.mortex.mvvm.data.model.api.login.LoginRequest.ServerLoginRequest;
import static com.power.mortex.mvvm.data.model.api.verifyPin.VerifyPinRequest.VerifyPin;
import static com.power.mortex.mvvm.data.remote.ApiEndPoint.ENDPOINT_SERVER_LOGIN;
import static com.power.mortex.mvvm.data.remote.ApiEndPoint.ENDPOINT_SERVER_VERIFY_PIN;
import static com.rx2androidnetworking.Rx2AndroidNetworking.post;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

//    @Override
//    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.ServerLoginRequest request) {
//        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
//                .addHeaders(mApiHeader.getPublicApiHeader())
//                .addBodyParameter(request)
//                .build()
//                .getObjectSingle(LoginResponse.class);
//    }
//
//    @Override
//    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request) {
//        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
//                .addHeaders(mApiHeader.getPublicApiHeader())
//                .addBodyParameter(request)
//                .build()
//                .getObjectSingle(LoginResponse.class);
//    }
//
//    @Override
//    public Single<LogoutResponse> doLogoutApiCall() {
//        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
//                .build()
//                .getObjectSingle(LogoutResponse.class);
//    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(ServerLoginRequest request) {
        return post(ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<VerifyPinResponse> verifyPinApiCall(VerifyPin request) {
        return post(ENDPOINT_SERVER_VERIFY_PIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(VerifyPinResponse.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

//    @Override
//    public Single<BlogResponse> getBlogApiCall() {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
//                .build()
//                .getObjectSingle(BlogResponse.class);
//    }
//
//    @Override
//    public Single<OpenSourceResponse> getOpenSourceApiCall() {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
//                .build()
//                .getObjectSingle(OpenSourceResponse.class);
//    }
}
