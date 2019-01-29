package com.power.mortex.mvvm.data.remote;


import static com.power.mortex.mvvm.BuildConfig.BASE_URL;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_BLOG = BASE_URL;

    public static final String ENDPOINT_SERVER_LOGIN = BASE_URL + "/gifto/user/v1/register/";

    public static final String ENDPOINT_SERVER_VERIFY_PIN = BASE_URL + "/gifto/user/v1/register/";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
