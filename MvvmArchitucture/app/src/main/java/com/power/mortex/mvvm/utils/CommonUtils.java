package com.power.mortex.mvvm.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.ColorDrawable;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.graphics.Color.TRANSPARENT;
import static android.provider.Settings.Secure.ANDROID_ID;
import static android.provider.Settings.Secure.getString;
import static android.util.Patterns.EMAIL_ADDRESS;
import static com.power.mortex.mvvm.R.layout.progress_dialog;
import static com.power.mortex.mvvm.utils.AppConstants.TIMESTAMP_FORMAT;
import static java.util.Locale.US;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public final class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return getString(context.getContentResolver(), ANDROID_ID);
    }

    public static String getTimestamp() {
        return new SimpleDateFormat(TIMESTAMP_FORMAT, US).format(new Date());
    }

    public static boolean isEmailValid(String email) {
        return EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
        }
        progressDialog.setContentView(progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
